override fun render() {
    // clear screen
    Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f)
    Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT)

    // draw game area
    drawGameArea()
    // draw control area
    drawControlArea()
}