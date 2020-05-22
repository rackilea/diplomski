if (!walkLoopIsPlaying && wantWalkLoopToBePlaying) {
    loopWalkSound = AssetLoader.walk.loop();
    if (loopWalkSound != -1) walkLoopIsPlaying = true;
} else if (walkLoopIsPlaying && !wantWalkLoopToBePlaying) {
    AssetLoader.walk.stop();
    walkLoopIsPlaying = false;
}