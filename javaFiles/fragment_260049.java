public static void main(String... args) {
    String macAddr = "AA:BB:CC:DD:";
    for (int i = 0; i < 256; i++) {
        for (int j = 0; j < 256; j++) {
            String fullAddr = String.format(macAddr + "%02X:%02X", i, j);
            System.out.println(fullAddr);
        }
    }
}