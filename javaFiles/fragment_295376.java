private static final int LIMIT = 255;
private static final int SHIFT = 256; // or whatever > LIMIT, e.g. 1000

public float colorToHeight(Color c){
    int b = (int) Math.round(c.getBlue() * LIMIT);
    int r = (int) Math.round(c.getRed() * LIMIT);
    float h = (b + r * SHIFT) / 2f;
    h -= 10000;
    return h;
}

public Color heightToColor(float h){
    h += 10000;
    h *= 2;         
    double r = (int) (h / SHIFT);
    double b = h - (r * SHIFT);
    return new Color(r / LIMIT, 0, b / LIMIT, 1f);
}