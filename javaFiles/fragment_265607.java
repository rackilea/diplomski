Picture enlarged = new Picture(getWidth() * 2, getHeight() * 2);
for (int x = 0; x < getWidth(); x++) {
    for (int y = 0; y < getHeight(); y++) {
        Pixel orig = getPixel(x,y);
        for(int x2 = 2*x; x2 < 2*x+2; x2++) {
            for(int y2 = 2*y; y2 < 2*y+2; y2++) {
                enlarged.getPixel(x2,y2).setColor(orig.getColor());
            }
        }
    }
}