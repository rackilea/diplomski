// To control the radius of moving
private final double MAX_X = 200;
private final double MAX_Y = 200;

private double angle = 0;

@Override
public void paint(Graphics g) {
    // increase angle (should be a double value)
    angle += 0.1;

    // rotate around P(0/0), assuming that 0° is vector (1/0)
    int x = (int) (Math.cos(angle) * MAX_X);
    int y = (int) (Math.sin(angle) * MAX_Y);

    // move P to center of JFrame (width and height = 1000)
    x += 500;
    y += 500;

    // image is 500x300, calc upper left corner
    x -= 250;
    y -= 150;

    // draw
    g.drawImage(img, x, y, null);
}