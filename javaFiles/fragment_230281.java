protected void changeContent(Container parent) {
    for (Component comp : parent.getComponents()) {
        adjustFont(comp);
        if (comp instanceof Container) {
            changeContent((Container)comp);
        }
    }
}

protected void changeFont(Component comp) {
    AffineTransformation at = AffineTransformation.getScaleInstance(2, 2);
    Font font = comp.getFont().deriveFont(at);
    comp.setFont(font);
}

public MyDialog() {
    changeContent(getConentPane());
}