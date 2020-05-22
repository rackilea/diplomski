void run() {
    Display display = new Display();
    Shell shell1 = openDocumentShell(display);
    Shell shell2 = openDocumentShell(display);

    // close both shells to exit
    while (!shell1.isDisposed() || !shell2.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}

Shell openDocumentShell(final Display display) {
    final Shell shell = new Shell(display, SWT.SHELL_TRIM);
    shell.setLayout(new FillLayout());
    Button button = new Button(shell, SWT.PUSH);
    button.setText("Open Modal Dialog");
    button.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            System.out.println("Button pressed, about to open modal dialog");
            final Shell dialogShell = new Shell(shell, SWT.PRIMARY_MODAL | SWT.SHEET);
            dialogShell.setLayout(new FillLayout());
            Button closeButton = new Button(dialogShell, SWT.PUSH);
            closeButton.setText("Close");
            closeButton.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    dialogShell.dispose();
                }
            });
            dialogShell.setDefaultButton(closeButton);
            dialogShell.addDisposeListener(new DisposeListener() {
                @Override
                public void widgetDisposed(DisposeEvent e) {
                    System.out.println("Modal dialog closed");
                }
            });
            dialogShell.pack();
            dialogShell.open();
        }
    });
    shell.pack();
    shell.open();
    return shell;
}