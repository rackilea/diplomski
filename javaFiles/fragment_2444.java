ShoutActivity.this.runOnUiThread(new Runnable() {

    public void run() {
        list.setAdapter(adapter);
    }
});