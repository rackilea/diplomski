int idx = 52428;
while (idx <= 0x40000) {
    String bits1 = Integer.toBinaryString(idx);
    String bits2 = Integer.toBinaryString(idx & -idx);
    idx += (idx & -idx);
    String bits3 = Integer.toBinaryString(idx);
    System.out.printf("%20s + %20s = %20s = %6d%n", bits1, bits2, bits3, idx);
}