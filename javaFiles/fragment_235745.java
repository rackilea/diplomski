import java.io.*;

class PrintHex
{
    public static void main(String[] args) 
    {
        byte[] raw = {0x30,0x04,0x12,0x54,0x33};
        byte[] raw1 = {'G','I','F'};
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ByteArrayOutputStream bo1 = new ByteArrayOutputStream();
        bo.write(raw,0,raw.length);
        bo1.write(raw1,0,raw1.length);

        System.out.println(bo);
        System.out.println(bo1);

        System.out.println("0x" + getHex(raw));
        System.out.println("0x" + getHex(raw1));
    }
    static final String HEXES = "0123456789ABCDEF";

    public static String getHex( byte [] raw ) {
        if ( raw == null ) {
           return null;
        }
        final StringBuilder hex = new StringBuilder( 2 * raw.length );
        for ( final byte b : raw ) {
           hex.append(HEXES.charAt((b & 0xF0) >> 4))
         .append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
   }
}