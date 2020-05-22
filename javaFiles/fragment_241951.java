public class DecimalTest
{
    public static int getDecimalFromBlock( byte... bytes ) {
        int result = 0;
        for(int i=0; i<bytes.length; i++)
        {
            result = result | (bytes[i] & 0xff)<<(i*8);
        }
        return result;
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println(getDecimalFromBlock(new byte[]{(byte)0xcb}));
        System.out.println(getDecimalFromBlock(new byte[]{(byte)0xcb, 0x01}));
        System.out.println(getDecimalFromBlock(new byte[]{(byte)0xcb, 0x01, 0x00}));
        System.out.println(getDecimalFromBlock(new byte[]{(byte)0xcb, 0x01, 0x00, 0x00}));
        System.out.println(getDecimalFromBlock(new byte[]{(byte)0xcb, 0x01, 0x00, 0x00, 0x00}));
    }
}