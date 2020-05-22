while (fxToolkitRunning()) {
    while (! timeForNextFrame()) {
        sleep(timeUntilNextFrame());
    }
    acquireFXApplicationThreadLock();
    if (sceneNeedsUpdating()) {
        renderFrame();
    }
    releaseFXApplicationThreadLock();
}