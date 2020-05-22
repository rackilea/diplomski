private String fileNameValue;

....

@Override
protected void okPressed()
{
  fileNameValue = fileNameText.getText();

  super.okPressed();
}