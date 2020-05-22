public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    StyledText text = new StyledText(shell, SWT.NONE);
    text.setEditable(false);
    text.setEnabled(false);
    text.setText("Blue and not blue");

    Color blue = display.getSystemColor(SWT.COLOR_BLUE);

    StyleRange range = new StyleRange(0, 4, blue, null);

    text.setStyleRange(range);

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}