public FileOutputStream(File file, boolean append)
    throws FileNotFoundException
{
    String name = (file != null ? file.getPath() : null);
    SecurityManager security = System.getSecurityManager();
    if (security != null) {
        security.checkWrite(name);
    }
    if (name == null) {
        throw new NullPointerException();
    }
    if (file.isInvalid()) {
        throw new FileNotFoundException("Invalid file path");
    }
    this.fd = new FileDescriptor();
    fd.attach(this);
    this.append = append;
    open(name, append);
}