public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("SWT RowLayout test");

    shell.setLayout(new GridLayout());
    Composite comp = new Composite(shell, SWT.NONE);
    comp.setLayout(new RowLayout(SWT.HORIZONTAL));
    comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for (int i = 0; i < 10; i++) {
        new Label(comp, SWT.NONE).setText("Label " + i);
    }

    shell.setSize(400, 250);
    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}