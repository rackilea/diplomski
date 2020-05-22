/**
 * Determines whether or not this <code>Rectangle</code> and the specified
 * <code>Rectangle</code> intersect. Two rectangles intersect if
 * their intersection is nonempty.
 *
 * @param r the specified <code>Rectangle</code>
 * @return    <code>true</code> if the specified <code>Rectangle</code>
 *            and this <code>Rectangle</code> intersect;
 *            <code>false</code> otherwise.
 */
public boolean intersects(Rectangle r) {
    int tw = this.width;
    int th = this.height;
    int rw = r.width;
    int rh = r.height;
    if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
        return false;
    }
    int tx = this.x;
    int ty = this.y;
    int rx = r.x;
    int ry = r.y;
    rw += rx;
    rh += ry;
    tw += tx;
    th += ty;
    //      overflow || intersect
    return ((rw < rx || rw > tx) &&
            (rh < ry || rh > ty) &&
            (tw < tx || tw > rx) &&
            (th < ty || th > ry));
}