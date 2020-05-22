@Override
protected void onStart() {
    super.onStart();
    new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        anim();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
}