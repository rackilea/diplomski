class CameraTransition {

    private final Vector3 startPos;
    private final Vector3 goalPos;
    private final float duration;

    private float stateTime = 0.0f;

    public CameraTransition(final Vector3 startPos, final Vector3 goalPos, float duration) {
        this.startPos = startPos;
        this.goalPos = goalPos;
        this.duration = duration;
    }

    public Vector3 act(float delta) {
        stateTime += delta;

        return startPos.lerp(goalPos, MathUtils.clamp(stateTime/duration, 0.0f,1.0f));
    }

}