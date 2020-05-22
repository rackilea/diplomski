for (long a = 1; ; a *= 7) {
    long x = Double.valueOf(a).longValue();
    if (x != a) {
        System.out.println("Conversion fails at input=" + a + " output=" + x);
        break;
    }
}