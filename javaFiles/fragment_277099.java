// draw objA adhering to viewportA (thus cameraA) <-- assume it's player cam
sb.setProjectionMatrix(cameraA.combined);
viewportA.apply();
objA.draw();

// draw objB adhering to viewportB (thus cameraB) <-- assume it's HUD cam
sb.setProjectionMatrix(cameraB.combined);
viewportB.apply(true);  // send in true as for HUD, we always want to center the screen
objB.draw();