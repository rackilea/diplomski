public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    Text text = new Text(shell, SWT.BORDER);
    text.setText("BLABLABLA");

    text.addListener(SWT.MouseUp, new Listener() {

        @Override
        public void handleEvent(Event event) {
            Text text = (Text) event.widget;

            String selection = text.getSelectionText();

            if(selection.length() > 0)
            {
                System.out.println("Selected text: " + selection);
            }
        }
    });

    text.addListener(SWT.KeyUp, new Listener() {

        @Override
        public void handleEvent(Event event) {
            Text text = (Text) event.widget;

            String selection = text.getSelectionText();

            if(selection.length() > 0 && event.keyCode == SWT.SHIFT)
            {
                System.out.println("Selected text: " + selection);
            }
        }
    });

    shell.pack();
    shell.open ();
    while (!shell.isDisposed ()) {
        if (!display.readAndDispatch ()) display.sleep ();
    }
    display.dispose ();
}