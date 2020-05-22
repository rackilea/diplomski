IProject project = workspace.getProject("Project");//assume this exists
IFolder link = project.getFolder("Link");
IPath location = new Path("C:\\temp\\folder");
    if (workspace.validateLinkLocation(link , location).isOK()) {
    try {
        link.createLink(location, IResource.NONE, null);
    } catch (CoreException e) {
        e.printStackTrace();
    }   
    } else {
      //invalid location, throw an exception or warn user
    }