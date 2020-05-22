public static BufferedImage[] splitImage(BufferedImage img, int cols, int rows) {
    int wCell = img.getWidth()/cols;
    int hCell = img.getHeight()/rows;
    int imageBlockIndex = 0;
    BufferedImage imgs[] = new BufferedImage[wCell *hCell ];
    for(int y = 0; y < rows; y++) {
        for(int x = 0; x < cols; x++) {
            imgs[imageBlockIndex] = new BufferedImage(wCell , hCell , img.getType());
            // Draw only one portion/cell of the image
            Graphics2D g = imgs[imageBlockIndex].createGraphics();
            g.drawImage(img, 0, 0, wCell , hCell , wCell *x, 
                                    hCell *y, wCell *x+wCell , hCell *y+hCell , null);
            g.dispose();
            imageBlockIndex++;
        }
    }
    return imgs;
}