IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
IEditorPart activeEditor = page.getActiveEditor();
if(activeEditor instanceof JavaEditor) {
    IJavaElement elt = ((JavaEditor) activeEditor).getElementAt(((TextSelection) activeEditor.getSelection()).getOffset(), true);
    if (elt.getElementType == IJavaElement.METHOD) {
        return (IMethod) elt;
    }
}
return null;