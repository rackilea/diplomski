class HandlerThreadExecutor implements Executor {
    private final Handler mHandler;
    public HandlerThreadExecutor(Handler optionalHandler) {
        mHandler = optionalHandler != null ? optionalHandler : new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable command) {
        mHandler.post(command);
    }
}