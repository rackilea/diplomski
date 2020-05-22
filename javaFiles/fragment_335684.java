public FindReplaceDialog(Shell parentShell) {
    super(parentShell);

    // .... other code ...

    setShellStyle(getShellStyle() ^ SWT.APPLICATION_MODAL | SWT.MODELESS);
    setBlockOnOpen(false);
}