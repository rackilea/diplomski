IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
for(IProject project: projects){
    try {
        project.delete(true, true, monitor);
    } catch (CoreException e) {
        e.printStackTrace();
    }
}