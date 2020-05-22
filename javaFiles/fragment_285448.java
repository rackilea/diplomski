if (x % 2 == 0 && x > y && x > z) {
    return x;
} else if (y % 2 == 0 && y > x && y > z) {
    return y;
} else if (z % 2 == 0 && z > x && z > y) {
    return z;
} else {
    return 0;
}