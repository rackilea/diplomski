private fun drawControlArea() {
    // the following twos to let system know we will operate against control area's camera
    // set the projection matrix
    sb.projectionMatrix = controlAreaCamera.combined
    // set gl viewport
    Gdx.gl.glViewport(0,GAMEVIEW_HEIGHT,GAME_WIDTH, CONTROLVIEW_HEIGHT)

    // draw your stuff here...
    sb.begin()
    ...
    sb.end()
}