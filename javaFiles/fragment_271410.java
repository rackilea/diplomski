mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
        @Override
        public void onScrollChanged() {
            int scrollY = mScrollView.getScrollY(); //for verticalScrollView
            if (scrollY == 0) 
                swipeRefresh.setEnabled(true);
            else 
                swipeRefresh.setEnabled(false);
        }
    });