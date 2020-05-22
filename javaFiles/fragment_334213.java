runOnUiThread(new Runnable() {

    @Override
    public void run() {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
 }