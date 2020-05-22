Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        while (true) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tryPass.setText(getAlphaNumericString());
                }
            });
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
});
thread.start();