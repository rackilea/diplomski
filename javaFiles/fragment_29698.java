public static BufferedImage replaceInsideBufferedImage(BufferedImage containingImage, BufferedImage toBeReplaced, BufferedImage replaceWithThis) {
    BufferedImage returnImage = deepCopyImage(containingImage);
    for (int x = 0; x+toBeReplaced.getWidth() < containingImage.getWidth(); x++) {
        for (int y = 0; y+toBeReplaced.getHeight() < containingImage.getHeight(); y++) {
            BufferedImage subImg = containingImage.getSubimage(x, y, toBeReplaced.getWidth(), toBeReplaced.getHeight());
            if (imageEquals(subImg,toBeReplaced)) {
                for (int sx = 0; sx < replaceWithThis.getWidth(); sx++) {
                    for (int sy = 0; sy < replaceWithThis.getHeight(); sy++) {
                        returnImage.setRGB(x+sx, y+sy, replaceWithThis.getRGB(sx, sy));
                    }
                }
            }
        }
    }
    return returnImage;
}