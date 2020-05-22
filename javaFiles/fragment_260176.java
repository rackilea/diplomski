Rectangle bounds = new Rectangle(randomX2, randomY2, boxImage.getWidth(), boxImage.getHeight());
Vector3 tmp = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
camera.unproject(tmp);

if (bounds.contains(tmp.x, tmp.y)) {
    System.out.println("Is touched");
}