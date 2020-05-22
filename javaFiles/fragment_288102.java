public static void main(String[] args) {
    final int n = 32;
    BigInteger bi = BigInteger.ZERO;
    BigDecimal rows = new BigDecimal(Math.pow(2, n));
    while (bi.compareTo(rows.toBigInteger()) < 0) {
        String bin = bi.toString(2);//Integer.toBinaryString(i);
        while (bin.length() < n)
            bin = "0" + bin;
        char[] chars = bin.toCharArray();
        boolean[] boolArray = new boolean[n];
        for (int j = 0; j < chars.length; j++) {
            boolArray[j] = chars[j] == '0' ? true : false;
        }
        System.out.println(Arrays.toString(boolArray));
        bi = bi.add(BigInteger.ONE);
    }
}