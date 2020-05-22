public static void main(String[] args) {
    int megaByte = 1024 * 1024;
    // prepare the paths
    Path inPath = Paths.get("D:/file.dat"); // java.nio.file.Paths
    Path outPath; // java.nio.file.Path
    try {
        outPath = Files.createTempFile(null, "swp"); // java.nio.file.Files
    } catch (IOException ex) {
        throw new IOError(ex);
    }

    // process the file
    try (
            FileChannel readChannel = new FileChannel.open(inPath, READ);
            FileChannel writeChannel = new FileChannel.open(outPath, WRITE, TRUNCATE_EXISTING)
    ) {
        long readFileSize = readChannel.size();
        long expectedWriteSize = readFileSize;
        if (readFileSize > 2 * megabyte)
            expectedWriteSize = readFileSize - megabyte;
        else if (readFileSize > megabyte)
            expectedWriteSize = megabyte;
        // copy first megabyte (or entire file if less than a megabyte)
        long bytesTrans = readChannel.transferTo(0, megabyte, writeChannel);
        // copy everything after the second megabyte
        if (readFileSize > 2 * megabyte)
            bytesTrans += readChannel.transferTo(2 * megabyte, readFileSize - 2 * megabyte, writeChannel);
        if (bytesTrans != expectedWriteSize)
            System.out.println("WARNING: Transferred " + bytesTrans + " bytes instead of " + expectedWriteSize);
    } catch (FileNotFoundException ex) {
        throw new RuntimeException("File not found!", ex);
    } catch (IOException ex) {
        throw new RuntimeException("Caught IOException", ex);
    }

    // replace the original file with the temporary file
    try {
        // ATOMIC_MOVE may cause IOException here . . .
        Files.move(outPath, inPath, REPLACE_EXISTING, ATOMIC_MOVE);
    } catch (IOException e1) {
        try {
            // . . . so it's probably worth trying again without that option
            Files.move(outPath, inPath, REPLACE_EXISTING);
        } catch (IOException e2) {
            throw new IOError(e2);
        }
    }
}