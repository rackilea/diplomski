private final static long MAX_VALUE = 1000000L;
private final static int TIME = 100L;

private final Handler handler = new Handler();
private long value = 1;


private void scheduleIncrementation() {
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            if (value < MAX_VALUE) {
                textView.setText(String.valueOf(value++));
            }

            handler.postDelayed(this, TIME);
        }
    }, TIME);
}