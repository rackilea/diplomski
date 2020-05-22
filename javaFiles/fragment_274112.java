public class CheckboxDialog extends Dialog {

    private String message = "";
    private String checkboxMessage = "";
    private boolean checkValue;

    private Button checkButton;

    /* Constructor, set shell style and set block on open (rest of gui is blocked until closed) */
    public CheckboxDialog(Shell parentShell) {
        super(parentShell);
        setShellStyle(SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.OK | SWT.APPLICATION_MODAL);
        setBlockOnOpen(true);
    }

    /* creates the content of the dialog */
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        /* set the layout for the content (gridlayout with 1 column)*/
        GridLayout layout = new GridLayout(1, false);
        layout.marginHeight = 15;
        layout.marginWidth = 30;
        composite.setLayout(layout);

        /* add a label with some text */
        final Label content = new Label(composite, SWT.NONE);
        content.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        content.setText(message);

        /* add a checkbox button */
        checkButton = new Button(composite, SWT.CHECK);
        checkButton.setText(checkboxMessage);
        checkButton.setSelection(true);
        checkButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        return composite;
    }

    /* create the dialog buttons (in this case, only an OK button) */
    protected void createButtonsForButtonBar(Composite parent)
    {
        createButton(parent, IDialogConstants.OK_ID, "OK", true);
    }

    /* configure the dialog's shell (set title) */
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Error");
    }

    /* this method is executed if the OK button is pressed */
    public void okPressed()
    {
        checkValue = checkButton.getSelection();
        close();
    }

    /* getter and setter methods */
    public void setMessage(String message) {
        this.message = message;
    }

    public void setCheckboxMessage(String checkboxMessage) {
        this.checkboxMessage = checkboxMessage;
    }

    public boolean getCheckBoxValue()
    {
        return checkValue;
    }
}