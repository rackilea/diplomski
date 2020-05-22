public class CustomDialog extends Dialog
{
    private String message = "";
    private Shell shell;

    public CustomDialog(Shell parent)
    {
        // Pass the default styles here
        this(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        shell = parent;
    }

    public CustomDialog(Shell parent, int style)
    {
        // Let users override the default styles
        super(parent, style);
        shell = parent;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void open()
    {
        shell.setText(getText());
        createContents(shell);
        shell.pack();
        shell.open();
        Display display = getParent().getDisplay();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        }
    }

    /**
     * Creates the dialog's contents
     * 
     * @param shell
     *            the dialog window
     */
    private void createContents(final Shell shell)
    {
        shell.setLayout(new GridLayout(3, true));

        // Show the message
        Label label = new Label(shell, SWT.NONE);
        label.setText(message);
        GridData data = new GridData();
        data.horizontalSpan = 3;
        label.setLayoutData(data);

        // Display the input box
        Label image = new Label(shell, SWT.NONE);
        image.setImage(shell.getDisplay().getSystemImage(SWT.ICON_ERROR));
        data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
        data.horizontalSpan = 3;
        image.setLayoutData(data);

        Button preview = new Button(shell, SWT.PUSH);
        preview.setText("Preview");
        data = new GridData(SWT.FILL, SWT.END, true, true);
        preview.setLayoutData(data);
        preview.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                System.out.println("Preview");
            }
        });

        Button delete = new Button(shell, SWT.PUSH);
        delete.setText("Delete");
        data = new GridData(SWT.FILL, SWT.END, true, true);
        delete.setLayoutData(data);
        delete.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                System.out.println("Delete");
            }
        });

        Button cancel = new Button(shell, SWT.PUSH);
        cancel.setText("Cancel");
        data = new GridData(SWT.FILL, SWT.END, true, true);
        cancel.setLayoutData(data);
        cancel.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent event)
            {
                shell.close();
            }
        });

        shell.setDefaultButton(preview);
    }

    public static void main(String[] args)
    {
        CustomDialog dialog = new CustomDialog(new Shell());
        dialog.setText("Title");
        dialog.setMessage("Message");

        dialog.open();
    }
}