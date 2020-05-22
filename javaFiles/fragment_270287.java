/**
 * Create contents of the button bar.
 * @param parent
 */
@Override
protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, "Test Button",
            true);
    createButton(parent, IDialogConstants.CANCEL_ID,
            IDialogConstants.CANCEL_LABEL, false);
}