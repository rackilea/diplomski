browser.addLoadListener(new LoadAdapter() {
    @Override
    public void onFinishLoadingFrame(FinishLoadingEvent event) {
        if (event.isMainFrame()) {
            Browser browser = event.getBrowser();
            JSValue value = browser.executeJavaScriptAndReturnValue("window");
            value.asObject().setProperty("Account", new Account());
        }
    }
});

browser.loadURL("form.html");