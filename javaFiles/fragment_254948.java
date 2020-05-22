private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
public void testMethod(){
    Runnable delayedTask = new Runnable() {
        @Override
        public void run() {
            Log.d("PPP : ","456");
        }
    };
    mainThreadHandler.postDelayed(delayedTask, 10000);
}