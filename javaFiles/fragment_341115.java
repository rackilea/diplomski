FileInputStream fruitInputStream = getFileInputStream(fruitMeta);
...
fis = getFileInputStream(file);

private static FileInputStream getFileInputStream(File file) {
    try {
        return new FileInputStream(file);
    catch(FileNotFoundException e) {
        return null;
    }
}