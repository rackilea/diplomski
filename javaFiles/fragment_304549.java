Long fileLastModified;
    File file = new File("file");
    if (!file.exists()) {
        syserr
    }
    if (file.lastModified() <= this.fileLastModified) {
        return oldValue;
    }
    this.fileLastModified = file.lastModified();