public boolean intersectsOrAttached(Rectangle r, Rectangle r2) {
    int tw = r.width;
    int th = r.height;
    int rw = r2.width;
    int rh = r2.height;
    if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
        return false;
    }

    int tx = r.x;
    int ty = r.y;
    int rx = r2.x;
    int ry = r2.y;
    rw += rx;
    rh += ry;
    tw += tx;
    th += ty;

    //overflow || intersect or attached
    return ((rw < rx || rw >= tx) &&
        (rh < ry || rh >= ty) &&
        (tw < tx || tw >= rx) &&
        (th < ty || th >= ry));
}