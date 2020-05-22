// this invocation...
JFrame jFrame = new JFrame("Hi!");

// effectively invokes following methods:

public JFrame(String title) throws HeadlessException {
    // ...
    frameInit();
}

protected void frameInit() {
    // ...
    setRootPane(createRootPane());
    // ...
}

protected JRootPane createRootPane() {
    JRootPane rp = new JRootPane();
    // ...
}

public JRootPane() {
    setGlassPane(createGlassPane());
    setLayeredPane(createLayeredPane());
    setContentPane(createContentPane());
    // ...
}

protected Container createContentPane() {
    JComponent c = new JPanel();             // <----
    // ...
    return c;
}