public void loadView() {
    Browser.invokeAndWaitFinishLoadingMainFrame(browser, new Callback<Browser>() {
        @Override
        public void invoke(Browser browser) {
            browser.loadHTML("");
        }
    });
    initLoginButton();
}