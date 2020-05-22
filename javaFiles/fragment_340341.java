public void move(float amount, float dir) {
    /* If you are moving straight ahead, or in reverse, modify the Y value for ascent/descent
     * Since you do not change your elevation if you are strafing, dir will be 0. sin(0) = 0, and the elevation will not change (regardless of whether rx is 0).
     * When you are moving forward or in reverse, dir will be 1, so the rotation about the x axis will be used, and the elevation will change (unless rx is 0).
     */
    y += amount * Math.sin(Math.toRadians(rx) * dir);

    /* If you are moving straight ahead, or in reverse, scale the delta X/Z (what comes after the +=) so that you don't move as far.
     * For example, if you are aimed straight up, and you move straight ahead (W/S), Math.cos(Math.toRadians(rx) * dir) will evaluate to 0, since you only want to move in the Y direction.
     * If you are aimed perfectly straight ahead (rotation about the x axis is 0), and you move straight ahead (A/D), Math.cos(Math.toRadians(rx) * dir) will evalute to 1, and your X/Z
     * movement would use the entire amount, since you are no longer moving in the Y direction.
     * If you are strafing (A/D), dir will be 0, and Math.cos(Math.toRadians(rx) * dir) will evalute to 1 (cos(0) == 1)). You will ONLY move in the X/Z directions when strafing.
     */
    z += amount * Math.cos(Math.toRadians(rx) * dir) * Math.sin((Math.toRadians(ry + 90 * dir)));
    x += amount * Math.cos(Math.toRadians(rx) * dir) * Math.cos((Math.toRadians(ry + 90 * dir)));
}