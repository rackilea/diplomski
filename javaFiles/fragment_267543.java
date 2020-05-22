@Override
protected void createButtonsForButtonBar(Composite parent) {
    super.createButtonsForButtonBar(parent);

    Button finish = getButton(IDialogConstants.FINISH_ID)
    finish.setText("Done");
    setButtonLayoutData(finish);
}