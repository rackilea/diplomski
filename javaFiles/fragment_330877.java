public List<MovableObject> getObjectsInRange(float x, float y, float x2, float y2) {
    final List<Fixture> list = new ArrayList<Fixture>();
    world.QueryAABB(new QueryCallback() {
        @Override
        public boolean reportFixture(Fixture fixture) {
            list.add(fixture);
            return true;
        }
    }, Math.min(x, x2), Math.min(y, y2), Math.max(x, x2), Math.max(y, y2));
    List<MovableObject> l = new ArrayList<MovableObject>();
    for (Fixture fixture : list) {
        l.add((MovableObject) fixture.getBody().getUserData());
    }
    return l;
}