JFrame frame = new JFrame();
frame.getContentPane().setLayout(new BorderLayout());

com.teamdev.jxbrowser.chromium.Browser browser = new com.teamdev.jxbrowser.chromium.Browser();
com.teamdev.jxbrowser.chromium.swing.BrowserView browserView = new com.teamdev.jxbrowser.chromium.swing.BrowserView(browser);

browser.setPopupHandler(new com.teamdev.jxbrowser.chromium.PopupHandler() {
    @Override
    public com.teamdev.jxbrowser.chromium.PopupContainer handlePopup(com.teamdev.jxbrowser.chromium.PopupParams params) {
        return new com.teamdev.jxbrowser.chromium.PopupContainer() {
            @Override
            public void insertBrowser(com.teamdev.jxbrowser.chromium.Browser popupBrowser, Rectangle initialBounds) {
                // do something with popupBrowser
                com.teamdev.jxbrowser.chromium.swing.BrowserView popupBrowserView = new com.teamdev.jxbrowser.chromium.swing.BrowserView(
                        popupBrowser);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(popupBrowserView, BorderLayout.CENTER);
                frame.getContentPane().validate();
                frame.getContentPane().repaint();
            }
        };
    }
});

frame.getContentPane().add(browserView, BorderLayout.CENTER);