if (x <= y) {
    // (x, y) is a normal interval, use normal interval intersect
    return low <= y && high >= x;
}
else {
    // (x, y) wraps
    return low <= y || high >= x;
}