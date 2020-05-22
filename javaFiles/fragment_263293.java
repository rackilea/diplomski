class OtherFontDisposer implements DisposeListener {
    @Override
    public void widgetDisposed(DisposeEvent e) {
        myCleverFontManager.disposeOfAll();
    }
}