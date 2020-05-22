public static IJavaModel prepareWorkspace() {
    IWorkspace workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceRoot workspaceRoot = workspace.getRoot();
    IJavaModel javaModel = JavaCore.create(workspaceRoot);
    return javaModel;
}