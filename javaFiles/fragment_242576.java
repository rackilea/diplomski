private void createBox(float posX, float posY, float boxW, float boxH) {
    BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyDef.BodyType.StaticBody;
    bodyDef.position.set(posX, posY);

    Body body = world.createBody(bodyDef);

    PolygonShape shape = new PolygonShape();
    shape.setAsBox(boxW / 2.f, boxH / 2.f);

    FixtureDef fixtureDef = new FixtureDef();
    fixtureDef.shape = shape;
    fixtureDef.density = 1f;

    Fixture fixture = body.createFixture(fixtureDef);

    shape.dispose();
}