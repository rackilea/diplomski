mainActivity.runOnUiThread( new Runnable() {

    @Override
    public void run() {
        Toast.makeText(mainActivity, "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
    }
} );