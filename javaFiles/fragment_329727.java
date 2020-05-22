public class BodyPartActor extends Actor {
    private static TextureRegion textureRegion = Globals.getTextureRegion();
    private static Color borderColor = Assets.getSkin().getColor("bodyPartBorder");
    private static Color fillColor = Assets.getSkin().getColor("bodyPartFill");
    private static short[] triangles = new short[] {
            0, 1, 2,         // Two triangles using vertex indices.
            0, 2, 3          // Take care of the counter-clockwise direction.
    };
    private static float borderThickness = 0.1f;
    private PolygonRegion polygonRegionBorder;
    private PolygonRegion polygonRegionFill;
    private BodyPart bodyPart;

    public BodyPartActor(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
        float[] vertices = this.bodyPart.getVertices();
        polygonRegionBorder = new PolygonRegion(textureRegion, vertices, triangles);
        polygonRegionFill = new PolygonRegion(textureRegion, calculateInnerVertices(vertices), triangles);
    }

    /**
     * @param v vertices of the outer quadrangle
     */
    private float[] calculateInnerVertices(float[] v) {
        Vector2 vA = calculateInnerVertex(v[6], v[7], v[0], v[1], v[2], v[3]);
        Vector2 vB = calculateInnerVertex(v[0], v[1], v[2], v[3], v[4], v[5]);
        Vector2 vC = calculateInnerVertex(v[2], v[3], v[4], v[5], v[6], v[7]);
        Vector2 vD = calculateInnerVertex(v[4], v[5], v[6], v[7], v[0], v[1]);
        return new float[]{vA.x, vA.y, vB.x, vB.y, vC.x, vC.y, vD.x, vD.y};
    }

    /**
     * Positive borderThickness value will produce vertex that is offseted to the inner side of the provided quadrangle.
     * Negative borderThickness value will produce vertex that is on the outer side of the quadrangle.
     */
    private Vector2 calculateInnerVertex(float prevX, float prevY, float curX, float curY, float nextX, float nextY) {
        Vector2 v = new Vector2(nextX - curX, nextY - curY);
        Vector2 w = new Vector2(prevX - curX, prevY - curY);
        Vector2 u = v.cpy().scl(w.len()).add(w.cpy().scl(v.len()));
        float absDetVW = Math.abs((v.x * w.y) - (v.y * w.x));
        return new Vector2(curX, curY).add(u.scl(borderThickness / absDetVW));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float x = bodyPart.getBody().getPosition().x;
        float y = bodyPart.getBody().getPosition().y;
        float rotation = bodyPart.getBody().getAngle() * MathUtils.radiansToDegrees;

        PolygonSpriteBatch polygonSpriteBatch = (PolygonSpriteBatch) batch;
        polygonSpriteBatch.setColor(borderColor.r, borderColor.g, borderColor.b, borderColor.a * parentAlpha);
        polygonSpriteBatch.draw(polygonRegionBorder, x, y, 0f, 0f, 1f, 1f, 1f, 1f, rotation);
        polygonSpriteBatch.setColor(fillColor.r, fillColor.g, fillColor.b, fillColor.a * parentAlpha);
        polygonSpriteBatch.draw(polygonRegionFill, x, y, 0f, 0f, 1f, 1f, 1f, 1f, rotation);
    }
}