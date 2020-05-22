public static void main(String[] args)
{
    Display d = new Display();
    final Shell shell = new Shell(d);
    shell.setLayout(new GridLayout(2, false));

    Label image = new Label(shell, SWT.NONE);
    image.setImage(d.getSystemImage(SWT.ICON_WARNING));
    image.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Label text = new Label(shell, SWT.NONE);
    text.setText("SOME TEXT HERE");
    text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));


    shell.pack();
    shell.open();
    while (!shell.isDisposed())
        while (!d.readAndDispatch())
            d.sleep();
}