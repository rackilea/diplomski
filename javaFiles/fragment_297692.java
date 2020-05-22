public void TimerMethod() {
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            Toast.makeText(getApplicationContext(), "Hi this is piyush", Toast.LENGTH_LONG).show();
        }
    });
}