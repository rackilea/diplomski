fun update(dt: Float, cam: Camera: viewport: Viewport) {
    // convert screen coordinate to world coordinate
    val location = Vector3(Gdx.input.getX(), Gdx.input.getY(), 0f)
    cam.unproject(location, viewport.screenX.toFloat(), viewport.screenY.toFloat(), viewport.screenWidth.toFloat(), viewport.screenHeight.toFloat())

    if ((Gdx.input.isTouched() && 
    boundingRect.contains(location.x, location.y)) {
        // do something here...
    }
}