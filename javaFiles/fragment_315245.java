public FileInputStream(File file) throws FileNotFoundException {
    String name = (file != null ? file.getPath() : null);
    SecurityManager security = System.getSecurityManager();
    if (security != null) {
        security.checkRead(name);
    }
        if (name == null) {
            throw new NullPointerException();
        }
    fd = new FileDescriptor();
    open(name);
    }