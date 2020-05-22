public RGB neg(int maxColorVal) {
    R = maxColorVal - R;
    G = maxColorVal - G;
    B = maxColorVal - B;
    return this;
}