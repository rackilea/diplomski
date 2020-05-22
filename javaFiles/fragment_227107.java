public File[] finder(String dirName, String filename){
    File dir = new File(dirName);

    return dir.listFiles(new FilenameFilter() { 
        public boolean accept(File dir, String name) {
            // check for exact filename:
            return name.equals(filename + ".xls");
            // use both parameters to check various files with filename pattern
            return name.endsWith(".xls") && name.startsWith(filename);

        }
    });
}