public static void main (String[] args)  throws Exception {
    File dir = new File("yourDir");

    FileFilter fileFilter = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };

    File[] files  = dir.listFiles(fileFilter);

    for (File f : files)
        System.out.println( f.getName() );
}