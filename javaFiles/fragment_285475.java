try {
    File file = new File("myFile");
    FileInputStream is = new FileInputStream(file);
    byte[] chunk = new byte[1024];
    int chunkLen = 0;
    while ((chunkLen = is.read(chunk)) != -1) {
        // your code..
    }
} catch (FileNotFoundException fnfE) {
    // file not found, handle case
} catch (IOException ioE) {
    // problem reading, handle case
}