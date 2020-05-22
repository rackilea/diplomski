public static void writeItem(OutputStream out, String s) throws IOException
{
    // Get the array of bytes for the string item:
    byte[] bs = s.getBytes(); // as bytes
    // Encapsulate by sending first the total length on 4 bytes :
    //   - bits 7..0 of length
    out.write(bs.length);      // modulo 256 done by write method
    //   - bits 15..8 of length
    out.write(bs.length>>>8);  // modulo 256 done by write method
    //   - bits 23..16 of length
    out.write(bs.length>>>16); // modulo 256 done by write method
    //   - bits 31..24 of length
    out.write(bs.length>>>24); // modulo 256 done by write method
    // Write the array content now:
    out.write(bs); // Send the bytes
    out.flush();
}

public static String readItem(InputStream in) throws IOException
{
    // first, read the total length on 4 bytes
    //  - if first byte is missing, end of stream reached
    int len = in.read(); // 1 byte
    if (len<0) throw new IOException("end of stream");
    //  - the other 3 bytes of length are mandatory
    for(int i=1;i<4;i++) // need 3 more bytes:
    {
        int n = in.read();
        if (n<0) throw new IOException("partial data");
        len |= n << (i<<3); // shift by 8,16,24
    }
    // Create the array to receive len bytes:
    byte[] bs = new byte[len];
    // Read the len bytes into the created array
    int ofs = 0;
    while (len>0) // while there is some byte to read
    {
        int n = in.read(bs, ofs, len); // number of bytes actually read
        if (n<0) throw new IOException("partial data");
        ofs += n; // update offset
        len -= n; // update remaining number of bytes to read
    }
    // Transform bytes into String item:
    return new String(bs);
}