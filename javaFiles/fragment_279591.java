public FileNode getChild(String name) throws InvalidFileDirectoryException {
    for (int i = 0; i < children.size(); i++) {
        if (children.get(i).getName().equals(name)) {
            return children.get(i);
        }
    }
    throw new InvalidFileDirectoryException(name + ": No such file or directory");
}