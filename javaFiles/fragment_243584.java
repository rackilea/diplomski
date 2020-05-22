private class CollectPathsVisitor extends ElementVisitor {
    public final Set<String> paths = new TreeSet<String>();
    public Object visit(Element element) {
        final IPath parentPath = (IPath) peek();
        final IPath path = parentPath.append(element.getLabel());
        if (!hasChildren(element))
            paths.add(path);
        return path;
    }
}