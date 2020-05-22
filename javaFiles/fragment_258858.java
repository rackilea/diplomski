IResource resource = (IResource)Platform.getAdapterManager().adapt(projectObj, IResource.class);

if (resource instanceof IProject)
 {
   IProject project = (IProject)resource;

   ... your code
 }