private ShapeRenderer shapeRenderer;
private Rectangle rectangle;

@Override
public void show() {
    shapeRenderer = new ShapeRenderer();
    rectangle = new Rectangle(0,0,10,10);
}

@Override
public void render(float delta) {
    shapeRenderer.begin();
    shapeRenderer.rect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    shapeRenderer.end();
}

@Override
public void dispose() {
    shapeRenderer.dispose();
}