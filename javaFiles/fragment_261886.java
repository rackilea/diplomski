public class FileExtensionFilter extends ViewerFilter {

  private String fTargetExtension;

  public FileExtensionFilter(String targetExtension) {
    fTargetExtension = targetExtension;
  }

  @Override
  public boolean select(Viewer viewer, Object parent, Object element) {
    if (element instanceof IFile) {
      return ((IFile)element).getName().toLowerCase().endsWith("." + fTargetExtension); 
    }

    if (element instanceof IProject && !((IProject)element).isOpen())
      return false;

    if (element instanceof IContainer) { // i.e. IProject, IFolder
      try {
        IResource[] resources = ((IContainer)element).members();
        for (IResource resource : resources) {
          if (select(viewer, parent, resource))
            return true;
        }
      } catch (CoreException e) {
        // Ignore
      }
    }

    return false;  
  }
}