public spiral_coords(int n) {
    if (n == 0) { 
        return Coords(0, 0);
    }
    // r = ring number.
    int r = (int)(ceil(0.5 * (-1.0 + sqrt(1.0 + 2.0 * n))));
    // n is the k-th number in ring r.
    int k = n - 2 * (r - 1) * r - 1;
    // n is the j-th number on its side of the ring. 
    int j = k % r;
    if (k < r) {
        return Coords(-j, r - j);
    } else if (k < 2 * r) {
        return Coords(-r - j, -j);
    } else if (k < 3 * r) {
        return Coords(j, -r - j);
    } else {
        return Coords(r - j, j);
    }
}