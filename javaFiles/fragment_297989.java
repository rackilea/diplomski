public class DynamicDialog extends Dialog 
{
    private int count = 1;

    public DynamicDialog(final Shell parent) 
    {
        super(parent);
    }

    @Override
    protected Control createDialogArea(final Composite parent) 
    {
        final Composite container = (Composite) super.createDialogArea(parent);
        container.setLayout(new FillLayout());

        final ScrolledComposite scrolledComposite = new ScrolledComposite(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        final Composite composite = new Composite(scrolledComposite, SWT.NONE);
        composite.setLayout(new GridLayout(1, false));
        scrolledComposite.setContent(composite);
        scrolledComposite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        final Composite composite_1 = new Composite(composite, SWT.NONE);
        composite_1.setLayout(new GridLayout(2, false));
        composite_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        final Label lblDefault = new Label(composite_1, SWT.NONE);
        lblDefault.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblDefault.setText("Default:");

        final Combo combo = new Combo(composite_1, SWT.NONE);
        combo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));

        final Composite composite_2 = new Composite(composite, SWT.NONE);
        composite_2.setLayout(new GridLayout(4, false));
        composite_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        final Composite composite_3 = new Composite(composite, SWT.NONE);
        composite_3.setLayout(new GridLayout());
        composite_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        final Button btnAdd = new Button(composite_3, SWT.NONE);
        btnAdd.setText("Add");
        btnAdd.addSelectionListener(new SelectionAdapter() 
        {
            @Override public void widgetSelected(final SelectionEvent e) 
            {
                final Label label2 = new Label(composite_2, SWT.NONE);
                label2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
                label2.setText( String.valueOf(count++) );

                new Text(composite_2, SWT.BORDER).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
                new Text(composite_2, SWT.BORDER).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
                new Button(composite_2, SWT.NONE).setText("Delete");

                // DO THIS:
                scrolledComposite.layout(true, true);
                scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
                // .. and it will work
            }
        });

        return container;
    }

    @Override
    protected void createButtonsForButtonBar(final Composite parent) 
    {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize() 
    {
        return new Point(450, 300);
    }

    public static void main(final String[] args)
    {
        final Shell shell = new Shell(new Display());
        shell.setLayout(new FillLayout());

        new DynamicDialog(shell).open();
    }
}