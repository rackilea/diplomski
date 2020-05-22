private static final int MAX_B = 300;

public String[] power2(BigInteger x) {
    increaseBase:
    for (BigInteger a = BigInteger.ONE; a.compareTo(x) <= 0; a = a.add(BigInteger.ONE)) {
        for (int b = 2; b <= MAX_B; b++) {
            BigInteger result = a.pow(b);
            if (result.equals(x)) {
                return new String[] {String.valueOf(a), String.valueOf(b)};
            }
            if (result.compareTo(x) == 1) {
                continue increaseBase;
            }
        }
    }

    return new String[] {String.valueOf(x), "1"};
}