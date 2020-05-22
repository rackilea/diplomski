private void runThread() {

    new Thread() {
        public void run() {
            while (continueAutoUpdate) {
                try {
                    handler.postDelayed(new Runnable(){
                        public void run(){
                            Log.e("updating...", "");
                            updateLogFromDatabase();
                        }
                    }, milliseconds);
                    Thread.sleep(milliseconds);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }.start();
}