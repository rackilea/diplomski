final View pagerContainer = (View) mView.findViewById(R.id.viewpagercontainer);
pagerContainer.post(new Runnable() {
    @Override
    public void run() {
        mViewPager.setContainerHeight(pagerContainer.getMeasuredHeight());
    }
});