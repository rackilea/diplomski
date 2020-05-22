private static final int NOTHING = 0;
private static final int WALL = 1;
private static final int PLAYER = 2;
private int type = NOTHING;
private Vector2 position;

@Override
public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {

    if (fixture.getFilterData().categoryBits == Application.WALL){
        type = WALL;
    }
    if (fixture.getFilterData().categoryBits == Application.PLAYER){
        type = PLAYER;
    }

    return fraction;
}