// your directory in which you look for index* files
    File directory = new File(".");
    // note that indexFileNames may be null
    String[] indexFileNames = directory.list(new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.startsWith("index");
        }
    });
    if (indexFileNames != null) {
        for (String name : indexFileNames) {
            System.out.println(name);
        }
    }