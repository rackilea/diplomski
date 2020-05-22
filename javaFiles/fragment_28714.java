final ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_view);
scrollView.post(new Runnable() {
    public void run() {
        scrollView.fullScroll(View.FOCUS_DOWN);
    }
});