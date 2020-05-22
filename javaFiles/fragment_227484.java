public static void main(String[] args) {
    byte[] swapped = nibbleSwap(new byte[]{(byte)0x91, 0x19, 0x38, 0x14, 0x47, 0x21, 0x11});
    for (byte b : swapped) {
        System.out.printf("%x ", b);
    }
    System.out.println();
}