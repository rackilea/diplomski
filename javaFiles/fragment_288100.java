public static void main(String[] args) {
    final int n = 3;
    for (int i = 0; i < Math.pow(2, n); i++) {
        String bin = Integer.toBinaryString(i);
        while (bin.length() < n)
            bin = "0" + bin;
        char[] chars = bin.toCharArray();
        boolean[] boolArray = new boolean[n];
        for (int j = 0; j < chars.length; j++) {
            boolArray[j] = chars[j] == '0' ? true : false;
        }
        System.out.println(Arrays.toString(boolArray));
    }
}