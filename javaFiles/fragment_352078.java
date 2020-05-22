public void getAllcontent(){
File dir = new File("dir");

        System.out.println("All content in Folders roog directory");
        List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println("file: " + file.getCanonicalPath());
        }
}