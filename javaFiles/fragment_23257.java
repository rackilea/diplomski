//opens the file for reading (using UTF-8 encoding)
private static Reader newReader(String pathToFile) {
    try {
        return new InputStreamReader(new FileInputStream(new File(pathToFile)), "UTF-8");
    } catch (Exception e) {
        throw new IllegalArgumentException("Unable to open file for reading at " + pathToFile, e);
    }
}

//creates a file for writing (using UTF-8 encoding)
private static Writer newWriter(String pathToFile) {
    try {
        return new OutputStreamWriter(new FileOutputStream(new File(pathToFile)), "UTF-8");
    } catch (Exception e) {
        throw new IllegalArgumentException("Unable to open file for writing at " + pathToFile, e);
    }
}