// resource is an IResource returned by sending 
   // an iCompilationUnit the getUnderlyingResource() method

if (resource.getType() == IResource.FILE) {

    IFile ifile = (IFile) resource;

    String path = ifile.getRawLocation().toString();

}