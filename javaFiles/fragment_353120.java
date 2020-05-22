public void set(float sx, float sy, float ex, float ey) {
    super.pointsDirty = true;
    start.set(sx, sy);     // this is line 217
    end.set(ex, ey);
    float dx = (ex - sx);
    float dy = (ey - sy);
    vec.set(dx,dy);

    lenSquared = (dx * dx) + (dy * dy);
}