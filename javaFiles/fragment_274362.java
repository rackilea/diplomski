public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    BazMessageDialog dialog = new BazMessageDialog(shell, "Information", null, "Getting List From Server", MessageDialog.INFORMATION, new String[]{"OK", "Cancel"}, 0);
    dialog.open();

    /* Do your stuff */

    dialog.reallyClose();

    shell.dispose();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}

public static class BazMessageDialog extends MessageDialog
{

    public BazMessageDialog(Shell parentShell, String dialogTitle,
            Image dialogTitleImage, String dialogMessage,
            int dialogImageType, String[] dialogButtonLabels,
            int defaultIndex) {
        super(parentShell, dialogTitle, dialogTitleImage, dialogMessage,
                dialogImageType, dialogButtonLabels, defaultIndex);
        setBlockOnOpen(false);
    }

    public void reallyClose()
    {
        cancelPressed();
    }

}