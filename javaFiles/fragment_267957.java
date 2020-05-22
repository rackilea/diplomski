public static BufferedImage trimHorizontally(BufferedImage img) {
    int width = img.getWidth(), height = img.getHeight();
    int x0, x1;
    int j, i;
    int alpha;

    leftLoop:
        for(i = 0; i < width; i++) {

            for(j = 0; j < height; j++) {
                if(new Color(img.getRGB(i, j), true).getAlpha() != 0)  {
                    break leftLoop;
                }
            }
        }
    x0 = i;
    rightLoop:
        for(i = width-1; i >= 0; i--) {

            for(j = 0; j < height; j++) {
                if(new Color(img.getRGB(i, j), true).getAlpha() != 0) {
                    break rightLoop;
                }
            }
        }
    x1 = i+1;

    return img.getSubimage(x0, 0, x1-x0, height);
}