public static File[] listFilesMatching(File root, String regex) {
    if(!root.isDirectory()) {
        throw new IllegalArgumentException(root+" is no directory.");
    }
    final Pattern p = Pattern.compile(regex); // careful: could also throw an exception!
    return root.listFiles(new FileFilter(){
        @Override
        public boolean accept(File file) {
            return p.matcher(file.getName()).matches();
        }
    });
}