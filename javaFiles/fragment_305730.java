static double bufferedImagesEqualConfidence(BufferedImage img1, BufferedImage img2) {
    int similarity = 0;
    int pixels = img1.getWidth() * img1.getHeight(); 
    if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {
                if (img1.getRGB(x, y) == img2.getRGB(x, y)) {
                    similarity++;
                }
            }
        }
    } else {
        return 0.0;
    }

    return similarity / (double)pixels;
}