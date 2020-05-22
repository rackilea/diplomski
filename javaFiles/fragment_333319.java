List<File> directories = Arrays.asList(home.listFiles(new FileFilter() {

    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }
}));