public String interpolate(float t) {
    int r = Math.round(ar * (1 - t) + br * t);
    int g = Math.round(ag * (1 - t) + bg * t);
    int b = Math.round(ab * (1 - t) + bb * t);

    return String.format("#%02x%02x%02x", r, g, b);
}