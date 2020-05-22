/**
* Imports the given path into the workspace as a project. Returns true if the
* operation succeeded, false if it failed to import due to an overlap.
*
* @param projectPath
* @return
* @throws CoreException if operation fails catastrophically
*/
private boolean importExisitingProject(IPath projectPath) throws CoreException {
    // Load the project description file
    final IProjectDescription description = workspace.loadProjectDescription(
    projectPath.append(IPath.SEPARATOR + IProjectDescription.DESCRIPTION_FILE_NAME));
    final IProject project = workspace.getRoot().getProject(description.getName());

    // Only import the project if it doesn't appear to already exist. If it looks like it
    // exists, tell the user about it.
    if (project.exists()) {
        System.err.println(SKTBuildPlugin.getFormattedMessage(
        "Build.commandLine.projectExists",  //$NON-NLS-1$
        project.getName()));
        return false;
    }
    IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
        public void run(IProgressMonitor monitor) throws CoreException {
            project.create(description, monitor);
            project.open(IResource.NONE, monitor);
        }
    };
    workspace.run(runnable,
    workspace.getRuleFactory().modifyRule(workspace.getRoot()),
    IResource.NONE, null);
    return true;
}