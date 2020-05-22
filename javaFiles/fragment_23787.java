CefApp.addAppHandler(new CefAppHandlerAdapter(null) {
    @Override
    public void onBeforeCommandLineProcessing(String s, CefCommandLine cefCommandLine) {
        cefCommandLine.appendSwitch("disable-image-loading");
    }

    @Override
    public void stateHasChanged(CefApp.CefAppState state) {
        if (state == CefApp.CefAppState.TERMINATED) System.exit(0);
    }
});