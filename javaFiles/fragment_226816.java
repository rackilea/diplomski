List<File> files = new ArrayList<File>(Arrays.asList(f.listFiles(
    new FilenameFilter() {
        @Override 
        public boolean accept(File dir, String name) {
            String[] split = name.split("\.");
            if(split.length == 1)
                return allowed.contains("");
            return allowed.contains(split[split.length - 1]);
        }
    }
)));