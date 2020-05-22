class FontDisposer implements DisposeListener {
    private List<Font> toDispose;

    public FontDisposer() {
        toDispose = new ArrayList<Font>();
    }

    @Override
    public void widgetDisposed(DisposeEvent e) {
            // Dispose all fonts in toDispose
    }

    public void registerFont(Font f) {
        toDispose.add(f);
    }
}

class UIWotsit extends SomeUIClass {
    private FontDisposer disposer;

    public UIWotsit() {
        disposer = new FontDisposer();
        addDisposeListener(disposer);
    }

    public void changeFont(Font f) {
        disposer.registerFont(f);
        // Do all the font changing stuff
    }
}