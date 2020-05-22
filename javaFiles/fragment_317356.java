if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                    @Override
                    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                        if (scrollY > 0 && fab2.isShown()) {
                            fab2.setVisibility(View.GONE);
                        } else if (scrollY < 0) {
                            fab2.setVisibility(View.VISIBLE);

                        }
                    }
                });
            } else {
                mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        int mScrollY = mScrollView.getScrollY();
                        if (mScrollY > 0 && fab2.isShown()) {
                            fab2.setVisibility(View.GONE);
                        } else if (mScrollY < 0) {
                            fab2.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }