@Override
public void selectionChanged(IWorkbenchPart part, ISelection selection) {
    Object[] allselections= null;
    selectedProjects.clear();
    // TODO Auto-generated method stub

    if(selection instanceof IStructuredSelection) {
        allselections = ((IStructuredSelection)selection).toArray();
        for(Object element: allselections){

            if (element instanceof IResource) {
                selectedProjects.add(((IResource)element).getProject());
            } else if (element instanceof IAdaptable) {
                IResource resource = null;
                IAdaptable a = (IAdaptable)element;
                resource = (IResource)a.getAdapter(IResource.class);
                selectedProjects.add(resource.getProject());

            }
        }
    }
};