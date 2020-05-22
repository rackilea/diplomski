public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    Label label = new Label(shell, SWT.NONE);
    label.setText("Blue and not blue");

    Color blue = display.getSystemColor(SWT.COLOR_BLUE);

    final TextLayout layout = new TextLayout(display);
    layout.setText("Blue and not blue");
    final TextStyle style = new TextStyle(display.getSystemFont(), blue, null);

    label.addListener(SWT.Paint, new Listener() {
        @Override
        public void handleEvent(Event event) {
            layout.setStyle(style, 0, 3);
            layout.draw(event.gc, event.x, event.y);
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();

}