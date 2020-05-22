this.runOnUiThread(new Runnable() {
    public void run() {
        Toast.makeText(MainActivity.this, "SMS Sending Failed.",
            Toast.LENGTH_SHORT).show();

    }
});