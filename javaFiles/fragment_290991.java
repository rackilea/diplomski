class GameEngine {
    private long nativeGameEnginePointer;

    private native long loadEngine();
    public GameEngine() {
        super(...);
        nativeGameEnginePointer = loadEngine();
    }

    private native void destroyEngine(long nativePointer);
    protected void finalize() throws Throwable {
        try {
            destroyEngine(nativeGameEnginePointer);
        } finally {
            super.finalize();
        }
    }

    private native double nativePlayGameOrWhatever(long nativePointer);
    public double playGameOrWhatever() {
        return nativePlayGameOrWhatever(nativeGameEnginePointer);
    }
}