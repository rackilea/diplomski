IPath path = ... absolute path to the file

IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
IFile file = root.getFileForLocation(path);
if (file != null) {
  IProject project = file.getProject();
  ...
}