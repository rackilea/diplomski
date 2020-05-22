while (1) {
    World.respondToInput();
    World.updatePhysics();
    World.renderScene();
    Timer.waitUntilFrameExpires();
}