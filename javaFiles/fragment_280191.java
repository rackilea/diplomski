public void setText (String string) {
  checkWidget();
  if (string == null) error (SWT.ERROR_NULL_ARGUMENT);

  if ((style & SWT.SEPARATOR) != 0) return;

  ...