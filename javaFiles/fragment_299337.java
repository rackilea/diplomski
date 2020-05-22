public static int maxArrayListValue(int[] arrayList) {
    int maxVal = Integer.MIN_VALUE;
    for (int vvv : arrayList) {
        if (vvv > maxVal) {
            maxVal = vvv;
        }
    }
    return maxVal;
}