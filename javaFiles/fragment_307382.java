private Button createButton(String text) {
    Button ret = new Button(parentComposite, SWT.CHECK);
    ret.setText(text);
    ret.setSelection(true);
    ret.setEnabled(true);
    ret.addSelectionListener(buttonAdapter);
}