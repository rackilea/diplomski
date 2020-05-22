public class Test {
    public static void main(String[] args) throws Exception {
        byte[] data = { (byte) 0xB6, (byte) 0x79, (byte) 0xC0, (byte) 0xAF, 
                (byte) 0x18, (byte) 0xF4, (byte) 0xE9, (byte) 0xC5, 
                (byte) 0x87, (byte) 0xAB, (byte) 0x8E, (byte) 0x20, 
                (byte) 0x0A, (byte) 0xCD, (byte) 0x4E, (byte) 0x48, 
                (byte) 0xA9, (byte) 0x3F, (byte) 0x8C, (byte) 0xB6 };

        String text = Base64.encodeBytes(data);
        System.out.println(text);
    }
}