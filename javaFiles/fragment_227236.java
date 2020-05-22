IAdapterManager adapter = Platform.getAdapterManager();

IResource resource = (IResource)adapter.getAdapter(selectedObject, IResource.class);

if (resource instanceof IFile)
 {
   ....
 }