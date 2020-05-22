public void doDelay(View view) {
        final TextView textView = (TextView) view;
        textView.setText("Sleeping");
        textView.post(new Runnable() {
            public void run() {
                try {
                    Log.d("Sleeper", "Thread " + Thread.currentThread() + " going to sleep...");
                    Thread.sleep(5000L);
                    Log.d("Sleeper", "Thread " + Thread.currentThread() + " now awake");
                    textView.setText("Ready");
                } catch (InterruptedException e) { finish(); }
            }
        });
    }