public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    new Button(shell, SWT.TOGGLE);
    new Scale(shell, SWT.HORIZONTAL);

    final Canvas invisible = new Canvas(shell, SWT.NONE);
    invisible.addListener(SWT.KeyDown, new Listener() {
        @Override
        public void handleEvent(Event event) {
        }
    });

    final Button radioButton1 = new Button(shell, SWT.RADIO);
    radioButton1.setText("text1");

    final Button radioButton2 = new Button(shell, SWT.RADIO);
    radioButton2.setText("text2");

    invisible.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            final boolean selection1 = radioButton1.getSelection();
            final boolean selection2 = radioButton2.getSelection();
            radioButton1.setFocus();
            radioButton1.setSelection(selection1);
            radioButton2.setSelection(selection2);
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    });

    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}