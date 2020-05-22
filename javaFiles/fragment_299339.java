class Krypte {
    public static void main (String [] args) {
        int i = 12345;
        String k = Integer.toString(i);
        System.out.println("Before: " + k);    
        String G = secure(k.toCharArray());
        System.out.println("Encrypted: " + G);
        String U = secure(G.toCharArray());
        System.out.println("Decrypted: " + U);
        int X = Integer.parseInt(U);
        System.out.println("As an int: " + X);
    }

    public static String secure(char[] msg) {
        // Variables
        int outLength = msg.length;
        byte secret = (byte) 0xAC; // same as 10101100b (Key)
        // XOR kryptering
        for (int i = 0; i < outLength; i++) {
            // encrypting each byte with XOR (^)
            System.out.println("Byte before: " + msg[i]);
            msg[i] = (char) (msg[i] ^ secret);
            System.out.println("Byte after: " + msg[i]);
        }
        return new String(msg);
    }
}