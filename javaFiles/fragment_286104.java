private static IFile addJar(IProject project, String srcPath, String targetPath, IProgressMonitor monitor) {
    URL srcURL = MyPlugin.getDefault().getBundle().getEntry(srcPath);
    IFile file = project.getFile(targetPath);
    InputStream is = null;
    try {
        is = srcURL.openStream();
        file.create(is, true, monitor);
    } catch (CoreException e) {//...
              } catch (IOException e) {//...
              }
    finally {
        try {
            if (is != null)
                is.close();
        } catch (IOException ignored) {}
    }
    return file;
}