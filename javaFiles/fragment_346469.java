public Animation (float frameDuration, Array<? extends T> keyFrames) {
    this.frameDuration = frameDuration;
    T[] frames = (T[]) new Object[keyFrames.size];
    for (int i = 0, n = keyFrames.size; i < n; i++) {
        frames[i] = keyFrames.get(i);
    }
    setKeyFrames(frames);
}