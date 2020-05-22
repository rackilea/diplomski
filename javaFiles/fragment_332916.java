private void calculateGlassValues(int value) {
    rectHeight = GLASS_HEIGHT * (value / 100.0);
    glassY = HORIZON - rectHeight;
    rect.setRect(GLASS_X, glassY, GLASS_WIDTH, rectHeight);
    System.out.print(rect.getBounds());
}