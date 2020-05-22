Display.getDefault().asyncExec(new Runnable() {
    @Override
    public void run() {
       PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("viewId");

    }
});