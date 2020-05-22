public static Handler UIHandler;

static {
    UIHandler = new Handler(Looper.getMainLooper());
}

public static void runOnUI(Runnable runnable) {
    UIHandler.post(runnable);
}