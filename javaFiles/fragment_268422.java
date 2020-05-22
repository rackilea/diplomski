final Text textField = new Text(shell, SWT.BORDER);

textField.addListener(SWT.Verify, new Listener() {

    @Override
    public void handleEvent(Event e) {
        // get old text and create new text by using the Event.text
        final String oldS = textField.getText();
        String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

        if(newS.length() > 0 && newS.charAt(0) == ' ')
            e.doit = false;
    }
});