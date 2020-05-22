public Object execute(ExecutionEvent event) throws ExecutionException
{
    TreeSelection selection = (TreeSelection)HandlerUtil.getCurrentSelection(event);
    IJavaElement je = (IJavaElement)selection.getFirstElement();
    IJavaProject jproj = je.getJavaProject();
    IProject proj = (IProject)jproj.getResource();
    IMavenProjectFacade facade = MavenPlugin.getMavenProjectRegistry().getProject(proj);
    Model mavenModel = facade.getMavenProject().getModel();
    //...
    return null;
}