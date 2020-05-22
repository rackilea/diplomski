private static void stackOverflowLoop() {
    CrashMe.stackOverflowLoop();
}
public void stackOverflow() {
    new Handler().postDelayed(new Runnable() {
        public void run() {
            CrashMe.stackOverflowLoop();
        }
    }, 2000);
}