IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

ISelection selection = page.getSelection();

if (selection instanceof IStructuredSelection) {
    Object selected = ((IStructuredSelection)selection).getFirstElement();

    ... cast selected to your object type
}