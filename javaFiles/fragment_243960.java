webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
        @Override
        public void loadingProgressChanged(WebBrowserEvent e) {
            if (e.getWebBrowser().getLoadingProgress() == 100) {
                ....
            }
        }
    });