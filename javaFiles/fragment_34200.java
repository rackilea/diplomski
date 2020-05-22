public boolean dispatchTouchEvent(MotionEvent ev) {
    View contentsView = findViewById(android.R.id.content);

    int test1[] = new int[2];
    contentsView.getLocationInWindow(test1);

    int test2[] = new int[2];
    contentsView.getLocationOnScreen(test2);

    System.out.println(test1[1] + " " + test2[1]);

    return super.dispatchTouchEvent(ev);
}