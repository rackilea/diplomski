for (int i = 0; i <= 49; i++) {
    Button b = new Button(numbersComposite, SWT.TOGGLE);

    // set the layout data
    GridData buttonLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
    b.setLayoutData(buttonLayoutData);

    b.setText("" + i);
    buttons.add(b);
}