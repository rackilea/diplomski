final static int SIZE = 4;

...

public void drawBigPixel(int x, int y, Color col) {
   gfx.setColor(col);
   gfx.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
}