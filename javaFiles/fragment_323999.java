@Override
    public void createCircle(float radius) {
        bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set(position);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape(); //here it should be CircleShape
        shape.setRadius(radius);