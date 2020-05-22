private void hookRecursively(Control c, MouseListener listener) {
    c.addMouseListener(listener);

    if (c instanceof Composite) {
        Control[] children = ((Composite) c).getChildren();
        for (Control element : children) {
            hookRecursively(element, listener);
        }
    }
}