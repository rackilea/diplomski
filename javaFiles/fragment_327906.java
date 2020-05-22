// time delay to hide actionBar
Handler h = new Handler();
h.postDelayed(new

Runnable() {
    @Override
    public void run () {
        startAnimate();
    }
}

,2000); // e.g. 2000 milliseconds