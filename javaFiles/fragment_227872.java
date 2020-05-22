protected final int speed;
protected final int height;

public Missile(int x, int y, int speed, int height, String file) {
    ImageIcon ii =
        new ImageIcon(this.getClass().getResource(file));
    image = ii.getImage();
    visible = true;
    this.speed = speed;
    this.height = height;
    this.x = x;
    this.y = y - Math.floor(height/2);
}