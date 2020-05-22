private final byte[] magic = { -119, 80, 78, 71 };

public boolean isPng(File file) throws IOException
{
    BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
    byte[] buffer = new byte[4];
    input.read(buffer, 0, buffer.length);
    boolean result = Arrays.equals(buffer, magic);
    input.close();
    return result;
}