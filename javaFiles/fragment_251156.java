public BufferedImage shiftColor(BufferedImage img, int rShift, int gShift,int bShift) {
    Color tmpCol;
    for (int x = 0; x < img.getWidth(); x++) {
        for (int y = 0; y < img.getHeight(); y++) {
            tmpCol=new Color(img.getRGB(x,y));
            tmpCol=new Color(tmpCol.getRed()-rShift,tmpCol.getGreen()-gShift,tmpCol.getBlue()-bShift);
            img.setRGB(x,y,tmpCol.getRGB());
        }
    }
    return img;
}