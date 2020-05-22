public static Path safeResolve(Path root, String subname) {
    Path subpath = root.normalize().resolve(subname).normalize();
    if(subpath.startsWith(root) && !Files.isSymbolicLink(subpath))
        return subpath;
    return null;
}