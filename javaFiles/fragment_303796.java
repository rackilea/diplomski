override fun create() {
    createBody()
    createBall()
    createGround()

    camera.setToOrtho(false, 800f, 480f)
    debugRenderer = Box2DDebugRenderer()
}