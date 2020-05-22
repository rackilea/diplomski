try (OutputStream out = Files.newOutputStream(file.toPath(),
                                              StandardOpenOption.WRITE))
{
    // exists and is writable
} catch (IOException) {
    // doesn't exist or can't be opened for writing 
}