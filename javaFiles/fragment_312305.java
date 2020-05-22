QueryCallback callback = new QueryCallback() {
    @Override
    public boolean reportFixture (Fixture fixture) {
        if (fixture.testPoint(point.x, point.y)) {
            bodyThatWasHit = fixture.getBody();
            return false;
        } else
            return true;
    }
};