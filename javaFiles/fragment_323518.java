@Override
protected void okPressed()
{
  IDialogSettings settings = Activator.getDefault().getDialogSettings();

  settings.putBoolean("checkbox setting key", checkbox.getSelection());

  super.okPressed();
}