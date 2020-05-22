public static void appendTo6(StringBuilder builder, double d) {
    if (d < 0) {
        builder.append('-');
        d = -d;
    }
    if (d * 1e6 + 0.5 > Long.MAX_VALUE) {
        // TODO write a fall back.
        throw new IllegalArgumentException("number too large");
    }
    long scaled = (long) (d * 1e6 + 0.5);
    long factor = 1000000;
    int scale = 7;
    long scaled2 = scaled / 10;
    while (factor <= scaled2) {
        factor *= 10;
        scale++;
    }
    while (scale > 0) {
        if (scale == 6)
            builder.append('.');
        long c = scaled / factor % 10;
        factor /= 10;
        builder.append((char) ('0' + c));
        scale--;
    }
}

@Test
public void testCases() {
    for (String s : "-0.000001,0.000009,-0.000010,0.100000,1.100000,10.100000".split(",")) {
        double d = Double.parseDouble(s);
        StringBuilder sb = new StringBuilder();
        appendTo6(sb, d);
        assertEquals(s, sb.toString());
    }
}

public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    long start = System.nanoTime();
    final int runs = 20000000;
    for (int i = 0; i < runs; i++) {
        appendTo6(sb, i * 1e-6);
        sb.setLength(0);
    }
    long time = System.nanoTime() - start;
    System.out.printf("Took %,d ns per append double%n", time / runs);
}