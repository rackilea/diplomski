ScrollView sv1 = (ScrollView)findViewById(R.id.scrollview1);
ScrollView sv2 = (ScrollView)findViewById(R.id.scrollview2);

sv1.getViewTreeObserver().addOnScrollChangedListener(new OnScrollChangedListener() {
    @Override
    public void onScrollChanged() {
        sv2.scrollTo(sv1.getScrollX(), sv1.getScrollY());
    }
});