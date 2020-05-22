public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    Text t1 = new Text(shell, SWT.SINGLE | SWT.BORDER);
    t1.setText("Test box...");

    Composite c = new Composite(shell, SWT.NONE);
    GridLayout layout = new GridLayout(2, true);

    layout.marginWidth = 0; // <-- HERE

    c.setLayout(layout);

    Text t2 = new Text(c, SWT.SINGLE | SWT.BORDER);
    t2.setText("Test box within Composite... not aligned to the first textbox");

    Button b = new Button(c, SWT.PUSH);
    b.setText("Button 1");

    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}