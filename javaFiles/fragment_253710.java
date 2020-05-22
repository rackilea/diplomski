private static Font italic;

public static void main(String[] args) {
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1,false));

    italic = new Font(Display.getCurrent(), "Verdana", 6, SWT.ITALIC);

    final Text text = new Text(shell, SWT.BORDER);

    text.addListener(SWT.Paint, new Listener() {

        @Override
        public void handleEvent(Event event) {

            if(text.getText().length() < 1 && !text.isFocusControl())
            {
                GC gc = event.gc;
                gc.setFont(italic);
                gc.setForeground(display.getSystemColor(SWT.COLOR_GRAY));

                Point size = text.computeSize(SWT.DEFAULT, SWT.DEFAULT);

                /* Strangely the y positioning doesn't work correctly */
                //gc.drawText("Please enter text", 1, (size.y / 2) - (italic.getFontData()[0].getHeight() / 2));
                gc.drawText("Please enter text", 1, 4);
            }
        }
    });

    text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Dummy");

    button.forceFocus();

    shell.setSize(200, 100);
    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }
    italic.dispose();
    display.dispose();
}