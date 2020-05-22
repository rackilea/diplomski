private Long x = 1000L;
private Runnable r = new Runnable() {
    @Override
    public void run() {
        // do some staff
        handler.postDelayed(this, x);
    }
}