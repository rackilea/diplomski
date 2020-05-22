IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

// This will print 'R/' string representation of the workspace root
System.out.println(root);

IPath fullPath = root.getFullPath();

// This will print the file path to the workspace root
System.out.println(fullPath.toOSString());