public static void main(final String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);

    shell.setSize(800, 600);
    shell.setText("Word Example");
    shell.setLayout(new FillLayout());

    try {
        frame = new OleFrame(shell, SWT.NONE);
        // esto abre un documento existente
        // clientSite = new OleClientSite(frame, SWT.NONE, new File("Doc1.doc"));
        // esto abre un documento en blanco
        clientSite = new OleClientSite(frame, SWT.NONE, "Word.Document");
        addFileMenu(frame);
        System.out.println(" I am in run method ");
    } catch (final SWTError e) {
        System.out.println("Unable to open activeX control");
        display.dispose();
        return;
    }

    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}