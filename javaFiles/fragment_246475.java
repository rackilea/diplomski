final int gameUnitsPerScreenDim = 32;

void render(JPanel panel, Graphics2D g2) {
    double pixelHeight = panel.getHeight();
    double pixelsPerGameUnit = pixelHeight / gameUnitsPerScreenDim;

    g2.scale(pixelsPerGameUnit, pixelsPerGameUnit);

    ...
}