public class Test {
    public static void main(String[] args) throws IOException {
        // 1 00000010 01000011 = 65536 + 2 * 256 + 67 = 66115
        // Creating a stream that repeats this number twice 
        // 10000001 00100001 1, 10000001 00100001 1
        // 10000001 00100001 11000000 10010000 11[000000] = 129, 33, 192, 144, 192
        byte[] data = { (byte) 129, 33, (byte) 192, (byte) 144, (byte) 192 };
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        BitReader br = new BitReader(in);
        // Should print 66115, 66115, 0
        System.out.println(br.readBits17());
        System.out.println(br.readBits17());
        System.out.println(br.readBits(6));
    }
}