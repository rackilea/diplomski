String expectedString = "PartOfFilename";
File folder = new File("/path/to/directory");

File[] listOfFiles = folder.listFiles();
for (File file : listOfFiles) {
    if (file.getName().contains(expectedString)) {
        //matching file found
    }
}