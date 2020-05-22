File[] jsonFiles=new File("sourcePath").listFiles(new FilenameFilter() {
        @Override
        public boolean accept(File arg0, String name) {
            return name.endsWith(".json");
        }
    });