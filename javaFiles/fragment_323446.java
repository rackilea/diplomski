Display display = Display.getDefault();
Shell dialogShell = new Shell(display, SWT.APPLICATION_MODAL);
// populate dialogShell
dialogShell.open();
while (!dialogShell.isDisposed()) {
    if (!display.readAndDispatch()) {
        display.sleep();
    }
}