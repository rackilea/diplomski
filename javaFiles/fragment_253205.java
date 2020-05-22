public class YourHandler extends AbstractHandler {

private ExecutionEvent event;

@Override
public Object execute(ExecutionEvent event) throws ExecutionException {

    // First get the tree of the right-clicked project.
    ISelection sel = HandlerUtil.getActiveMenuSelection(event);

    IResource resource = null;
    IProject project = null;

    try {
        IStructuredSelection selection = (IStructuredSelection) sel;

        // Get the first element of the tree (return type Object).
        Object firstElement = selection.getFirstElement();

        // Get the IResource and from this the IProject of the selection.
        if (firstElement instanceof IAdaptable) {
            IResource resource = (IResource) (((IAdaptable) firstElement)
                .getAdapter(IResource.class));

            project = res.getProject();
        }
    } catch (ClassCastException e) {
        // Do nothing.
    }

    // Then you can do something with the project.

    return project;
}