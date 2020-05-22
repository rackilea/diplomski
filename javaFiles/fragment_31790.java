public static void myWriteInt(OutputStream out, int value) throws IOException
{
    out.write(value % 0xff);
    out.write( (value >> 8) % 0xff);
    out.write((value >> 16) % 0xff);
    out.write((value >> 24) % 0xff);

}
public static void main(String[] args) throws Exception
{

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    // Replace with
    // OutputStream out = socket.getOutputStream()

    out.write((byte) 37);
    out.write((byte) 37);

    myWriteInt(out, 26);
    out.write((byte) 0);

    myWriteInt(out, 1);
    myWriteInt(out, 11);

    out.write("SET_PROBLE\0".getBytes("UTF-8"));

    System.out.println(DatatypeConverter.printHexBinary(out.toByteArray()));