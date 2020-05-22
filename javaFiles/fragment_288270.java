IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

IEditorPart editor = page.getActiveEditor();

IEditorInput input = editor.getEditorInput();

IFile file = (IFile)Platform.getAdapterManager().getAdapter(input, IFile.class);