IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
IProject project = root.getProject(projectName);
if (!project.exists()) {
    project.create(monitor);
} else {
    project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
}

// TODO add files

project.refreshLocal(IResource.DEPTH_INFINITE, monitor);