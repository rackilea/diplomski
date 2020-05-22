// get all the files from a directory
File[] fList = directory.listFiles();
for (File file : fList) {
    if (file.isFile()) {
        files.add(file);
    } else if (file.isDirectory()) {
        listf(file.getAbsolutePath(), files);
    }
}