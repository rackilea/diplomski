/**
 * Write the byte array to the given file.
 *
 * @param file The file to write to
 * @param data The data array
 * @throws IOException
 */

public static void writeData(FileObject file, byte[] data)
        throws IOException {
    OutputStream out = null;
    try {
        FileContent content = file.getContent();
        out = content.getOutputStream();
        out.write(data);
    } finally {
        close(out);
    }
}