private static Handler mHandler = new Handler(Looper.getMainLooper());

mHandler.post(new Runnable() {

        @Override
        public void run() {
            lMessages.add(0,message);
            ...
}