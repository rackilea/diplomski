if (Gdx.input.justTouched()) {
    Vector3 touchPos = new Vector3();
    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
    camera.unproject(touchPos);
    if (raindrop.contains(touchPos.x,touchPos.y)) {
        dropSound.play();
        iter.remove();
   }
}