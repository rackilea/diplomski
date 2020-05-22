public class GdxTest extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;
    Polygon polygonTest;

    @Override
    public void create() {

        shapeRenderer= new ShapeRenderer();

        float x1 = 200;
        float y1 = 200;
        float x2 = 250;
        float y2 = 200;
        float x3 = 250;
        float y3 = 250;
        float x4 = 200;
        float y4 = 250;

        float[] f = {x1,y1,x2,y2,x3,y3,x4,y4};

        polygonTest = new Polygon();
        polygonTest.setVertices(f);
        polygonTest.setOrigin(x1+25,y1+25);
        polygonTest.rotate(-45f);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (polygonTest.getRotation()<360){
            polygonTest.setRotation(polygonTest.getRotation()+1);
        }else
            polygonTest.setRotation(0);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.polygon(polygonTest.getTransformedVertices());
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}