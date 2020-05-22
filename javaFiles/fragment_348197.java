@Override
public void postWindowOpen() {

IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

    try {
        page.openEditor(editorInput, editorId);
    } catch (PartInitException e) {
        // Handle the exception here
    }
}