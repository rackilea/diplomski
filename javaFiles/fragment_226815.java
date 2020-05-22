List<File> files = new ArrayList<File>(Arrays.asList(f.listFiles(
    new FilenameFilter() {
        @Override 
        public boolean accept(File dir, String name) {
            return name.endsWith(".ext");
        }
    }
)));