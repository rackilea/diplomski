public static void main(String[] args) {
    Integer[] flags = {
            0b0101_0101_0101_0101_0101_0101_0101_0101,
            0b0101_0101_0101_0101_0101_0101_0101_0101,
            0b0101_0101_0101_0101_0101_0101_0101_0101
    };
    for (Integer flag : flags) {
        System.out.println(Arrays.toString(getBooleanArray(flag)));
    }
}

private static boolean[] getBooleanArray(Integer value) {
    String valueAsString = Integer.toBinaryString(value).replaceFirst("^0+(?!$)", "");
    return convertToBinary(value, valueAsString.length());
}

private static boolean[] convertToBinary(int b, int size) {
    boolean[] binArray = new boolean[size];
    boolean bin;
    for (int i = size - 1; i >= 0; i--) {
        if (b % 2 == 1) bin = true;
        else bin = false;
        binArray[i] = bin;
        b /= 2;
    }
    return binArray;
}