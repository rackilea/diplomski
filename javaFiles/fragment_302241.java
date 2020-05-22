public interface IBird {
    public Point getPosition()
}

class Bird implements IBird {
    private Point position;

    public Bird(int x, int y) {
        this.position = new Point(x, y);
    }

    public Point getPosition() {
        return this.position;
    }
}

// and then in main()
Bird bird = new Bird(3, 8);
Point pos = bird.getPosition();
System.out.println("X: " + pos.getX() + ", Y: " + pos.getY() );