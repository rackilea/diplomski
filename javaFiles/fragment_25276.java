protected boolean contains(Area area, float x, float y) {
    double length = .0002;
    double up = 1.0001;
    double down = .9999;
    return area.intersects(x < 0 ? x*up : x*down, y < 0 ? y*up : y*down, Math.abs(x*length), Math.abs(y*length));
}