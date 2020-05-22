public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));
    shell.setText("StackOverflow");

    Composite scaleComp = new Composite(shell, SWT.NONE);
    scaleComp.setLayout(new GridLayout(3, false));

    CLabel leftImage = new CLabel(scaleComp, SWT.RIGHT_TO_LEFT);
    leftImage.setText("Left");
    leftImage.setImage(display.getSystemImage(SWT.ICON_ERROR));
    leftImage.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));

    final Scale scale = new Scale (scaleComp, SWT.NONE);
    scale.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    scale.setMaximum (4);
    scale.setPageIncrement (1);
    scale.setSelection(4);

    CLabel rightImage = new CLabel(scaleComp, SWT.NONE);
    rightImage.setText("Right");
    rightImage.setImage(display.getSystemImage(SWT.ICON_INFORMATION));
    rightImage.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}