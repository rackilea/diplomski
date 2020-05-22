public class InputDialog extends Dialog {
    private Text txtName;
    private String value;

    public InputDialog(Shell parentShell) {
        super(parentShell);
        value = "";
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        parent.setLayout(new GridLayout(1, false));

        txtName = new Text(parent, SWT.NONE);

        return super.createDialogArea(parent);
    }

    @Override
    protected void okPressed() {
        value = txtName.getText();
    }

    public String getEnteredText() {
        return value;
    }
}