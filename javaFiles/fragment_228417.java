public static int getMinValue(int[] ary) {
    random(ary);
    if (ary.length > 0) {
        int minValue = ary[0];
        for (int i = 1; i < ary.length; i++) {
            if (ary[i] < minValue)
                minValue = ary[i];
        }
        System.out.printf("Minvalue:%d", minValue);
        return minValue;
    }
    throw new RuntimeException("The array must contain at least one element");
}