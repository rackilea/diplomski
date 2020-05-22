class MyWebChromeClient extends WebChromeClient {

    private boolean mOnReceivedTitleInvoked;

    @Override
    public synchronized void onReceivedTitle(final WebView view, final String title) {
        if (!mOnReceivedTitleInvoked) {
            mOnReceivedTitleInvoked = true;
            Log.v("onReceivedTitle", "=>" + title);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    super.onReceivedTitle(view, title);
                    mOnReceivedTitleInvoked = false;
                }
            }, 1000);
        }
    }

}