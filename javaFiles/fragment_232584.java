FileObject appRoot = FileUtil.getConfigRoot().getFileObject("myapp");

try {
    FileObject fo = servers.createData(filename);
    fo.setAttribute("name", "a name");
    fo.setAttribute("desc", "a description");

    // Lock the FileObject before writing
    FileLock lock;
    try {
        lock = fo.lock();
    } catch (FileAlreadyLockedException ex) {
        Exceptions.printStackTrace(ex);
        return;
    }

    try {
        OutputStream out = fo.getOutputStream(lock);
        try {
            // Write into the output stream
        } finally {
            // Remember to close the stream
            out.close();
        }
    } finally {
        lock.releaseLock();
    }
} catch (IOException ex) {
    throws new FileCreationException("Could not create file " + filename, ex);            
}