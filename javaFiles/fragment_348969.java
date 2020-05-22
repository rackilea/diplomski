for (int i = 1; i <= 5; i++) {
    float a = 100 * i;
    float b = 100 * i;
    for (int j = 1; j <= 24; j++) {
        float x = (float) (a * Math.sin(Math.toRadians(15 * j)));
        float y = (float) (b * Math.cos(Math.toRadians(15 * j)));
        pointlist.add(new Point((int)x, (int)y));
    }
}