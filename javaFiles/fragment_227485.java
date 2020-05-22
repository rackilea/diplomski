public class NibbleSwap {

    private static String nibbleSwap(byte []inByte){
        String ret = "";
        for(int i = 0; i < inByte.length; i++)
        {
                int nibble0 = (inByte[i] << 4) & 0xf0;
                int nibble1 = (inByte[i] >>> 4) & 0x0f;
                byte b = (byte)((nibble0 | nibble1));
                ret += String.format("%x ", b);
        }

        return ret;
    }  

    public static void main(String[] args) {
        System.out.println(nibbleSwap(new byte[]{(byte)0x91,0x19,0x38,0x14,0x47,0x21,0x11}));
    }

}