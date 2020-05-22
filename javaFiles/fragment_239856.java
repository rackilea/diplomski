public static String decompose(double d) {
    int SIGN_WIDTH = 1;
    int EXP_WIDTH = 11;
    int SIGNIFICAND_WIDTH = 53;
    String s = String.format("%64s", Long.toBinaryString(Double.doubleToRawLongBits(d))).replace(' ', '0');
    return s.substring(0, 0 + SIGN_WIDTH) + " "
            + s.substring(0 + SIGN_WIDTH, 0 + SIGN_WIDTH + EXP_WIDTH) + " "
            + s.substring(0 + SIGN_WIDTH + EXP_WIDTH, 0 + SIGN_WIDTH + EXP_WIDTH + SIGNIFICAND_WIDTH - 1);
}

public static void test() {
    // Use a fixed seed so the generated numbers are reproducible.
    java.util.Random r = new java.util.Random(0);

    // Generate a floating point number that makes use of its full 52 bits of significand precision.
    double a = r.nextDouble() * 100;
    System.out.println(decompose(a) + " " + a);
    Assert.assertFalse(decompose(a).split(" ")[2].substring(23).equals(String.format("%0" + (52 - 23) + "d", 0)));

    // Cast the double to a float to produce a "ground truth" of precision loss to compare against.
    double b = (float) a;
    System.out.println(decompose(b) + " " + b);
    Assert.assertTrue(decompose(b).split(" ")[2].substring(23).equals(String.format("%0" + (52 - 23) + "d", 0)));
    // 32-bit float has a 23 bit significand, so c's bit pattern should be identical to b's bit pattern.
    double c = reducePrecision(a, 23);
    System.out.println(decompose(c) + " " + c);
    Assert.assertTrue(b == c);

    // 23rd-most significant bit in c is 1, so rounding it to the 22nd-most significant bit requires breaking a tie.
    // Since 22nd-most significant bit in c is 0, d will be rounded down so that its 22nd-most significant bit remains 0.
    double d = reducePrecision(c, 22);
    System.out.println(decompose(d) + " " + d);
    Assert.assertTrue(decompose(d).split(" ")[2].substring(22).equals(String.format("%0" + (52 - 22) + "d", 0)));
    Assert.assertTrue(decompose(c).split(" ")[2].charAt(22) == '1' && decompose(c).split(" ")[2].charAt(21) == '0');
    Assert.assertTrue(decompose(d).split(" ")[2].charAt(21) == '0');
    // 21st-most significant bit in d is 1, so rounding it to the 20th-most significant bit requires breaking a tie.
    // Since 20th-most significant bit in d is 1, e will be rounded up so that its 20th-most significant bit becomes 0.
    double e = reducePrecision(c, 20);
    System.out.println(decompose(e) + " " + e);
    Assert.assertTrue(decompose(e).split(" ")[2].substring(20).equals(String.format("%0" + (52 - 20) + "d", 0)));
    Assert.assertTrue(decompose(d).split(" ")[2].charAt(20) == '1' && decompose(d).split(" ")[2].charAt(19) == '1');
    Assert.assertTrue(decompose(e).split(" ")[2].charAt(19) == '0');

    // Reduce the precision of a number close to the largest normal number.
    double f = reducePrecision(a * 0x1p+1017, 23);
    System.out.println(decompose(f) + " " + f);
    // Reduce the precision of a number close to the smallest normal number.
    double g = reducePrecision(a * 0x1p-1028, 23);
    System.out.println(decompose(g) + " " + g);
    // Reduce the precision of a number close to the smallest subnormal number.
    double h = reducePrecision(a * 0x1p-1051, 23);
    System.out.println(decompose(h) + " " + h);
}