public static void doDid(final Callable<Void> callable) {
    final Handler handler = new Handler();

    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            try {
                callable.call();
                handler.postDelayed(this, every * repeattime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }, every * tempvalue);
}