// worker thread
TouchUtils.clickView(this, mButton);
instrumentation.runOnMainSync(new Runnable() {
    @Override
    public void run() {
        instrumentation.callActivityOnStop(mActivity);
        instrumentation.callActivityOnResume(mActivity);
        assertTrue(View.GONE == mButton.getVisibility());
    }
});