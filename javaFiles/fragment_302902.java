t.setText("Test!");
t.postDelayed(new Runnable() {
    @Override
    public void run() {
       t.setText("Test - after 1 second!");
    }
}, 1000);