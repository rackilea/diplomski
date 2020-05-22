protected Color[][] computeIntensity(Color[][] pixels) {
    int height = pixels.length;
    int width = pixels[0].length;
    Color[][] intensity = new Color[height][width];
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            Color c = pixels[i][j];
            intensity[i][j] = new Color(c.getRed() * 0.299, c.getGreen() * 0.587, c.getBlue() * 0.114);
        }
    }
    return intensity;
}

outPixels = computeIntensity(inPixels);