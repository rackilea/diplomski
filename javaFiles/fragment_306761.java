int lineNumber = ...
IPath path = ...
IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
IMarker marker = file.createMarker(IMarker.TEXT);
marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
IDE.openEditor(page, marker);
marker.delete();