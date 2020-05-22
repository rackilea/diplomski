IRegion region = JavaCore.newRegion();
for (IJavaElement i : javaProject.getPackageFragmentRoots())
{
    String elementName = i.getElementName();
    if (!elementName.endsWith("jar") && !elementName.endsWith("zip"))
        region.add(i);
    }

    NullProgressMonitor progressMonitor = new  NullProgressMonitor();

    // for getting a class hierarchy for type
    ITypeHierarchy typeHierarchy= type.newTypeHierarchy(progressMonitor);
    // for getting all the class hierarchies of the region in the project
    ITypeHierarchy typeHierarchy= javaProject.newTypeHierarchy(region, progressMonitor);
}