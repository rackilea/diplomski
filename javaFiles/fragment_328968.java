public void checkOutThisFixture(Fixture fixture) {
    Shape fixtureShape = fixture.getShape();
    if (fixtureShape instanceof PolygonShape) {
        PolygonShape polygonShape = (PolygonShape) fixtureShape;
        Float minX = null;
        Float maxX = null;
        Float minY = null;
        Float maxY = null;
        for (int i = 0; i < polygonShape.getVertexCount(); i++) {
            Vec2 nextVertex = polygonShape.getVertex(i);
            float x = nextVertex.x;
            float y = nextVertex.y;
            if (minX == null || x < minX) {
                minX = x;
            }
            if (maxX == null || x > maxX) {
                maxX = x;
            }
            if (minY == null || y < minY) {
                minY = y;
            }
            if (maxY == null || y > maxY) {
                maxY = y;
            }
        }
        float width = maxX - minX;
        float height = maxY - minY;
        float halfWidth = width / 2;
        float halfHeight = height / 2;
        System.out.println("The polygon has half width & height of: " + halfWidth + " & " + halfHeight);
    } else if (fixtureShape instanceof CircleShape) {
        float radius = ((CircleShape) fixtureShape).m_radius;
        System.out.println("The circle has a radius of : " + radius);
    } else {
        // TODO handle other shapes
    }
}