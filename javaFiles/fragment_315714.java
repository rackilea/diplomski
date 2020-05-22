x11.XSetErrorHandler(new XErrorHandler() {

    @Override
    public int apply(Display display, XErrorEvent errorEvent) {
        System.err.println("bad fish " + errorEvent);
        return 0;
    }
});