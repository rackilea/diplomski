public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    new OptionsDialog(shell).open();

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}

private static class OptionsDialog extends Dialog {

    private Composite composite;

    public OptionsDialog(Shell parentShell)
    {
        super(parentShell);
        setShellStyle(parentShell.getStyle() | SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
        setBlockOnOpen(true);
    }

    protected Control createDialogArea(Composite parent) {
        this.composite = (Composite) super.createDialogArea(parent);

        GridLayout layout = new GridLayout(1, false);
        layout.marginHeight = 5;
        layout.marginWidth = 10;

        composite.setLayout(layout);

        createContent();

        return composite;
    }

    private void createContent()
    {
        /* add your widgets */
    }

    protected void configureShell(Shell newShell)
    {
        super.configureShell(newShell);
        newShell.setText("Shell name");
    }

    public void okPressed()
    {
        /* DO NOTHING HERE!!! */
        //this.close();
    }
}