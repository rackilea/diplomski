public static void main(String[] args) {
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Text textField = new Text(shell, SWT.BORDER);

    textField.addVerifyListener(new VerifyListener() {

        @Override
        public void verifyText(VerifyEvent e) {

            Text text = (Text)e.getSource();

            // get old text and create new text by using the VerifyEvent.text
            final String oldS = text.getText();
            String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

            boolean isFloat = true;
            try
            {
                Float.parseFloat(newS);
            }
            catch(NumberFormatException ex)
            {
                isFloat = false;
            }

            System.out.println(newS);

            if(!isFloat)
                e.doit = false;
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }
}