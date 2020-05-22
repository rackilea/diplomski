Bundle bundle = MyPlugin.getDefault().getBundle();
String templateFolderName = "template";
for (Enumeration entries = bundle.findEntries(templateFolderName, "*", true);
        entries.hasMoreElements();) {
    URL url = (URL) entries.nextElement();
    String path = url.getPath();
    if (!path.startsWith("/" + templateFolderName + "/"))
        throw new InvocationTargetException(
                new Throwable("Unknown template file: " + path));

    // create folder or file (overwrite if file already exists)
    String targetPath = path.substring(("/" + templateFolderName).length());
    if (path.endsWith("/")) {
        IFolder folder = project.getFolder(targetPath);
        if (! folder.exists()) {
            folder.create(false, true, null);
        }
    } else {
        InputStream in = url.openStream();
        IFile file = project.getFile(targetPath);
        if (file.exists()) {
            file.delete(true, null);
        }
        file.create(in, true, null);
    }
}