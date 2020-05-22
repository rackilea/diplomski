if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
    cam.translate(-3, 0, 0); // Moves the camera to the left.
}
if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
    cam.translate(3, 0, 0);  // Moves the camera to the right.
}