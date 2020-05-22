public class CreateDialog extends Dialog
{
  public CreateDialog(final Shell parentShell)
  {
    super(parentShell);
  }

  @Override
  protected void configureShell(final Shell newShell)
  {
    super.configureShell(newShell);

    newShell.setText("Create Object");
  }

  @Override
  protected void createButtonsForButtonBar(Composite parent)
  {
    createButton(parent, IDialogConstants.OK_ID, "Create", true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
 }

  @Override
  protected Control createDialogArea(Composite parent)
  {
    Composite body  = (Composite)super.createDialogArea(parent);

    String [] list = {"e", "e1"};

    Label label = new Label(body, SWT.NULL);
    label.setText("Entry point: ");

    for (String item: list) {
        Button btn = new Button(body, SWT.RADIO);
        btn.setText(item);
    }

    return body;
  }
}