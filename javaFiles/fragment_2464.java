public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    Group outerGroup = new Group(shell, SWT.NONE);

    // Tell the group to stretch in all directions
    outerGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    outerGroup.setLayout(new GridLayout(2, true));
    outerGroup.setText("Group");

    Button left = new Button(outerGroup, SWT.PUSH);
    left.setText("Left");

    // Tell the button to stretch in all directions
    left.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Button right = new Button(outerGroup, SWT.PUSH);
    right.setText("Right");

    // Tell the button to stretch in all directions
    right.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    shell.setSize(1000,400);
    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}