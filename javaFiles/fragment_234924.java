public class WindowAdapter implements WindowListener {
    static Consumer<WindowEvent> NO_OP = ev -> {};
    public static WindowAdapter window() {
        return new WindowAdapter(NO_OP, NO_OP, NO_OP, NO_OP, NO_OP, NO_OP, NO_OP);
    }
    final Consumer<WindowEvent> opened, closing, closed,
        iconified, deiconified, activated, deactivated;

    public WindowAdapter(Consumer<WindowEvent> opened, Consumer<WindowEvent> closing,
        Consumer<WindowEvent> closed, Consumer<WindowEvent> iconified,
        Consumer<WindowEvent> deiconified, Consumer<WindowEvent> activated,
        Consumer<WindowEvent> deactivated) {
        this.opened = opened;
        this.closing = closing;
        this.closed = closed;
        this.iconified = iconified;
        this.deiconified = deiconified;
        this.activated = activated;
        this.deactivated = deactivated;
    }
    public WindowAdapter onOpened(Consumer<WindowEvent> c) {
        Objects.requireNonNull(c);
        return new WindowAdapter(opened==NO_OP? c: opened.andThen(c),
            closing, closed, iconified, deiconified, activated, deactivated);
    }
    public WindowAdapter onClosing(Consumer<WindowEvent> c) {
        Objects.requireNonNull(c);
        return new WindowAdapter(opened, closing==NO_OP? c: closing.andThen(c),
            closed, iconified, deiconified, activated, deactivated);
    }
    public WindowAdapter onClosed(Consumer<WindowEvent> c) {
        Objects.requireNonNull(c);
        return new WindowAdapter(opened, closing, closed==NO_OP? c: closed.andThen(c),
            iconified, deiconified, activated, deactivated);
    }
    public WindowAdapter onIconified(Consumer<WindowEvent> c) {
        Objects.requireNonNull(c);
        return new WindowAdapter(opened, closing, closed,
          iconified==NO_OP? c: iconified.andThen(c), deiconified, activated, deactivated);
    }
    public WindowAdapter onDeiconified(Consumer<WindowEvent> c) {
        Objects.requireNonNull(c);
        return new WindowAdapter(opened, closing, closed, iconified,
            deiconified==NO_OP? c: deiconified.andThen(c), activated, deactivated);
    }
    public WindowAdapter onActivated(Consumer<WindowEvent> c) {
        Objects.requireNonNull(c);
        return new WindowAdapter(opened, closing, closed, iconified,
            deiconified, activated==NO_OP? c: activated.andThen(c), deactivated);
    }
    public WindowAdapter onDeactivated(Consumer<WindowEvent> c) {
        Objects.requireNonNull(c);
        return new WindowAdapter(opened, closing, closed, iconified,
            deiconified, activated, deactivated==NO_OP? c: deactivated.andThen(c));
    }
    @Override public void windowOpened(WindowEvent e) { opened.accept(e); }
    @Override public void windowClosing(WindowEvent e) { closing.accept(e); }
    @Override public void windowClosed(WindowEvent e) { closed.accept(e); }
    @Override public void windowIconified(WindowEvent e) { iconified.accept(e); }
    @Override public void windowDeiconified(WindowEvent e) { deiconified.accept(e); }
    @Override public void windowActivated(WindowEvent e) { activated.accept(e); }
    @Override public void windowDeactivated(WindowEvent e) { deactivated.accept(e); }
}