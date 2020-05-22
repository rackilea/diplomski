private static Color brightness(Color c, double scale) {
    int r = Math.min(255, (int) (c.getRed() * scale));
    int g = Math.min(255, (int) (c.getGreen() * scale));
    int b = Math.min(255, (int) (c.getBlue() * scale));
    return new Color(r,g,b);
}