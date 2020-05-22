public void test() {
    // Sample 24-bit tap found on page 5 of
    // http://www.xilinx.com/support/documentation/application_notes/xapp052.pdf
    int[] taps = new int[]{24, 23, 22, 17};
    LFSR lfsr = new LFSR(taps);
    int count = 100;
    for (BigInteger i : lfsr) {
        System.out.println("Colour: " + new Color(i.intValue()));
        if (--count <= 0) {
            break;
        }
    }
}