if (fileToOpen.exists() && fileToOpen.isFile()) {
    Stirng path = // file path that to be input.;
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    URI fromString = org.eclipse.core.runtime.URIUtil.fromString("file://" + path);
    try {
        IEditorPart openEditor = IDE.openEditor(page, fromString, XYZEditor.ID, true);
        IEditorInput editorInput = openEditor.getEditorInput();
        //editorInput.
    } catch ( PartInitException e ) {
        //Put your exception handler here if you wish to
    }
}