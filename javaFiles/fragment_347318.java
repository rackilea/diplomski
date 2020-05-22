Display.getDefault().syncExec(new Runnable() {

    @Override
    public void run() {
         MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "Message");
    }
});