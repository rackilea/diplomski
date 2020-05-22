shell.setLayout(new GridLayout(1, false));

  Composite childComposite = new Composite(shell, SWT.BORDER);

  // Composite fills the grid row
  childComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

  // Use 5 equal sized columns
  childComposite.setLayout(new GridLayout(5, true));

  // First text fills the first column
  Text text1 = new Text(childComposite, SWT.NONE);
  text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

  // Second text fills the next 4 columns
  Text text2 = new Text(childComposite, SWT.NONE);
  text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));

  Label label = new Label(shell, SWT.NONE);
  label.setText("Very loooooooooooooooooooooooong text");