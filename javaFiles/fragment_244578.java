static byte[][] cache = new byte[256][];
public static void writeInt(final String filename, final int value)
{
    // time will be spent on integer to string conversion, so cache that
    byte[] bytesToWrite = cache[value];
    if (bytesToWrite == null) {
        bytesToWrite = cache[value] = String.valueOf(value).getBytes();
    }

    FileOutputStream fileOutputStream = null;
    try {
        // Now write the byte array to file
        fileOutputStream = new FileOutputStream(filename);
        fileOutputStream.write(bytesToWrite);
        fileOutputStream.close();
    } catch (IOException exception) {
        // Error handling here
    } finally {
        if (fileOutputStream != null) {
            fileOutputStream.close()
        }
    }
}