private void updateRotationSpeed(float dt) {
    x += dx * dt;
    y += dy * dt;

    dxStatic = dx;
    dyStatic = dy;
}

public static float getPlayerDeltaX() {
    return dxStatic;
}

public static float getPlayerDeltaY() {
    return dyStatic;
}