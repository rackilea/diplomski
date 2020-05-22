private boolean isScrollingDown = true;
private Runnable _smoothScrollRunnable = new Runnable() {
    @Override
    public void run() {
        if (isScrollingDown && !_scrollView.canScrollVertically(1)) {
            // We can't scroll down any further so start scrolling up ...
            isScrollingDown = false;
        } else if (!isScrollingDown && !_scrollView.canScrollVertically(-1) {
            // We can't scroll up any further so start scrolling down ...
            isScrollingDown = true;
        }

        if (isScrollingDown) {
            // Scroll down by 2
            _scrollView.smoothScrollBy(0, 2);
        } else {
            // Scroll up by 2
            _scrollView.smoothScrollBy(0, -2);          
        }

        // Just keep scrolling forever ...
        _scrollView.postDelayed(_smoothScrollRunnable, 75);
    }
};