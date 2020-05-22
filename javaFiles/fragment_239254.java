public Orb(Bitmap bmp, int x, int y) {
    this.bitmap = bmp;
    this.x = x;
    this.y = y;
    halfBmpX = bmp.getWidth() / 2;
    halfBmpY = bmp.getHeight() / 2;
}