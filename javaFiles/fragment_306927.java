public class Render {


public int width, height;
    public int[] pixels;

    public Render(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void draw(Render render, int xOffset, int yOffset) {
        int xPixel, yPixel, y, x;
        for (x = 0; x < render.width; x++) {
            xPixel = x + xOffset;
            for (y = 0; y < render.height; y++) {
                yPixel = y + yOffset;
                pixels[xPixel + yPixel * width] = render.pixels[xPixel-xOffset + (yPixel-yOffset) * render.width];
            }
        }
    }
}