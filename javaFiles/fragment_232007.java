public Spatial rotate(float xAngle, float yAngle, float zAngle) {
    TempVars vars = TempVars.get();
    Quaternion q = vars.quat1;
    q.fromAngles(xAngle, yAngle, zAngle);
    rotate(q);
    vars.release();

    return this;
}