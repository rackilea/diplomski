File dir = new File("/path");
    File max = null;
    for (File file : dir.listFiles()) {
        if (file.isDirectory() && (max == null || max.lastModified() < file.lastModified())) {
            max = file;
        }
    }