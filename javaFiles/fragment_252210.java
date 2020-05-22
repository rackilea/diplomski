@Override
    public void onDetach() {
        super.onDetach();
//        Log.i("onDetach", "FeedPrincipalList");
        mList = null;
        timelinePage = 1;
        mPageCount = 0;
    }

    @Override
    public void onStart() {
        super.onStart();
//        Log.i("onStart", "FeedPrincipalList");
        this.mFlipView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStop() {
        super.onStop();
//        Log.i("onStop","FeedPrincipalList");
        this.mFlipView.setVisibility(View.INVISIBLE);
    }