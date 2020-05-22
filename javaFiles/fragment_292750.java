public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(2, true));

    // Stretch first label horizontally
    Label upperLeft = new Label(shell, SWT.NONE);
    upperLeft.setText("Label 1 name");
    upperLeft.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));

    // Stretch second label horizontally but align to the right
    Label upperRight = new Label(shell, SWT.NONE);
    upperRight.setText("time");
    upperRight.setLayoutData(new GridData(SWT.END, SWT.BEGINNING, true, false));

    // Stretch button comp in both directions
    Composite buttonComp = new Composite(shell, SWT.BORDER);
    buttonComp.setLayout(new GridLayout(1, true));
    GridData buttonData = new GridData(SWT.FILL, SWT.FILL, true, true);
    buttonData.horizontalSpan = 2;
    buttonComp.setLayoutData(buttonData);

    Button one = new Button(buttonComp, SWT.PUSH);
    one.setText("Button 1");
    one.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    Button two = new Button(buttonComp, SWT.PUSH);
    two.setText("Button 2");
    two.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    Button three = new Button(buttonComp, SWT.PUSH);
    three.setText("Button 3");
    three.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    // Stretch third label horizontally
    Label lowerLeft = new Label(shell, SWT.NONE);
    lowerLeft.setText("Label 2");
    lowerLeft.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));

    // Stretch fourth label horizontally
    Label lowerRight = new Label(shell, SWT.NONE);
    lowerRight.setText("Label 3");
    lowerRight.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}