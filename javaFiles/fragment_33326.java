Array<Vector2> verts = new Array<Vector2>();
Fixture f = body.getFixtureList().get(0);
PolygonShape s = f.shape;

// this is needed to temporarily keep the vertex, getVertex is a void method
Vector2 tmp = new Vector2();
for (int i = 0; i < s.getVertexCount(); i++) {
    // fill tmp with the vertex
    s.getVertex(i, tmp));
    verts.add(new Vector2(tmp));
}