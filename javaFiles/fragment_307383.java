List<Button> buttons = new ArrayList<>();
for (int i = 1; i <= 4; i++) {
    Button button = new Button(parentComposite, SWT.CHECK);
    button.setText("Button" + i);
    button.setSelection(true);
    button.setEnabled(true);
    button.addSelectionListener(buttonAdapter);
    buttons.add(button);
}