private ArrayList<String> getXmlFiles(File directory) {
    ArrayList<String> names = new ArrayList<>();
    directory.mkdirs();
    File[] files = directory.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".xml");
        }
    });
    for(File f : files)
        names.add(f.getPath());

    System.out.println("MYFILE:" + names);
    return files.length > 0 ? names : null;
}