IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
IEditorPart activeEditor = page.getActiveEditor();
if(activeEditor instanceof JavaEditor) {
    ITypeRoot root = EditorUtility.getEditorInputJavaElement(this, false);
    TextSelection sel = ((TextSelection) activeEditor.getSelection());
    IJavaElement elt = root.codeSelect(sel.getOffset(), sel.getLength();
    if (elt.getElementType == IJavaElement.METHOD) {
        return (IMethod) elt;
    }
}
return null;