public ScopePath pathToClassName(Path file) {
    if (!isValidClass(file))
        return null;

    Path relativePath = root.relativize(root.resolve(file));
    String withoutExtension = removeExtension(relativePath.toString());
    return new ScopePath(withoutExtension.replace(File.separator, "."));
}


private String getRelativePath(Path p) {
    String relativePath = packageDir.relativize(p)
            .toString();

    if (File.separator.equals("\\")) {
        relativePath = relativePath.replace("\\", "/");
    }

    return relativePath;
}