@Override
public Object execute(ExecutionEvent event) throws ExecutionException {

    ISelection selection = HandlerUtil.getCurrentSelection(event);
    if (selection instanceof IStructuredSelection) {
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        Object firstElement = structuredSelection.getFirstElement();
        if (firstElement instanceof IFile) {
            IFile file = (IFile) firstElement;
            IProject project = file.getProject();
            IFolder srcGenFolder = project.getFolder("src-gen");
            if (!srcGenFolder.exists()) {
                try {
                    srcGenFolder.create(true, true,
                            new NullProgressMonitor());
                } catch (CoreException e) {
                    return null;
                }
            }

            final EclipseResourceFileSystemAccess fsa = fileAccessProvider.get();
            fsa.setOutputPath(srcGenFolder.getFullPath().toString());

            URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
            ResourceSet rs = resourceSetProvider.get(project);
            Resource r = rs.getResource(uri, true);
            generator.doGenerate(r, fsa);

        }
    }