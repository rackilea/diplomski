String path_to_directory = "path to directory";
File file = new File(path_to_directory);
String[] contents = file.list();
for (String item : contents) {
    File itemFile = new File(file, item);
    if (itemFile.isDirectory()) {
        // process as directory
    } else {
        // process as ordinary file
    }
}