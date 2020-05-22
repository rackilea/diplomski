private fun drawGameArea() {
    // the following twos to let system know we will operate against game area's camera
    // set the projection matrix
    sb.projectionMatrix = gameAreaCamera.combined
    // set gl viewport
    Gdx.gl.glViewport(0,0,GAME_WIDTH, GAMEVIEW_HEIGHT)

    // draw your stuff here...
    sb.begin()
    ...
    sb.end()
}