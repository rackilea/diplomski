@Override
protected Control createDialogArea(Composite parent) {
  Control result = super.createDialogArea(parent);

  Text text = getText();  // The input text

  GridData data = new GridData(SWT.FILL, SWT.TOP, true, false);
  data.heightHint = convertHeightInCharsToPixels(5); // number of rows 
  text.setLayoutData(data);

  return result;
}

@Override
protected int getInputTextStyle() {
  return SWT.MULTI | SWT.BORDER;
}