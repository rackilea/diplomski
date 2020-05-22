public abstract class GameObject {
    protected final GameSession session;
    protected final int id;
    protected Point position;
    protected final width;
    protected final height;

public GameObject(GameSession session, Point position, int width, int height) {
    this.position = position;
    this.id = session.getNewId();
    this.session = session;
    this.width = width;
    this.height = height;
}

    public Bar getBar() {
        return new Bar(position, position.getX() + width, position.getY() + height);
    }
}