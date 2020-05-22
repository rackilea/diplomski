ViewParent parent = ...; // Should be the RecyclerView
if (slideOffset > 0.1 && slideOffset < 0.9) {
    parent.requestDisallowInterceptTouchEvent(true);
} else {
    parent.requestDisallowInterceptTouchEvent(false);
}