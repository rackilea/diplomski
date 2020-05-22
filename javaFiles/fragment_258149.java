ajaxResponseRenderer.addCallback(new JavaScriptCallback() {
    public void run(JavaScriptSupport javascriptSupport) {
        if (!canAddMorePhones()) {
            javascriptSupport.addScript("document.getElementById('addRowLink').style.display = 'none';");
        }
    }
});