private Handler handler;
private Runnable runnable = new Runnable() {
    @Override
    public void run() {
                     finish();
                     startActivity(getIntent());
    }
}