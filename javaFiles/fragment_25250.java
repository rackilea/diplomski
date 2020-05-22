URL url = this.getClass().getResource(myResource);
    String fileName;
    if (url.getProtocol().equals("file")) {
        fileName = url.getFile();        
    } else if (url.getProtocol().equals("jar")) {
        JarURLConnection jarUrl = (JarURLConnection) url.openConnection();
        fileName = jarUrl.getJarFile().getName();            
    } else {
        throw new IllegalArgumentException("Not a file");
    }
    File file = new File(fileName);
    long lastModified = file.lastModified();