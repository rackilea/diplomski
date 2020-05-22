public void beginContact(Contact contact) {
}

public void endContact(Contact contact) {
}

public void postSolve(Contact contact, ContactImpulse impulse) {
}

private final PointState[] state1 = new PointState[Settings.maxManifoldPoints];
private final PointState[] state2 = new PointState[Settings.maxManifoldPoints];
private final WorldManifold worldManifold = new WorldManifold();

public void preSolve(Contact contact, Manifold oldManifold) {
    Manifold manifold = contact.getManifold();

    if (manifold.pointCount == 0) {
        return;
    }

    Fixture fixtureA = contact.getFixtureA();
    Fixture fixtureB = contact.getFixtureB();

    Collision.getPointStates(state1, state2, oldManifold, manifold);

    contact.getWorldManifold(worldManifold);

    for (int i = 0; i < manifold.pointCount
            && pointCount < MAX_CONTACT_POINTS; i++) {
        ContactPoint cp = points[pointCount];
        cp.fixtureA = fixtureA;
        cp.fixtureB = fixtureB;
        cp.position.set(worldManifold.points[i]);
        cp.normal.set(worldManifold.normal);
        cp.state = state2[i];
        ++pointCount;
    }
}