public static int numberOfPairs(int[] a, int k ) {
    int len = a.length;
    int counter = 0;
    boolean isCheckedLeft = false;
    boolean isCheckedRight = false;
    int i, j, h;

    Arrays.sort(a);
    for (i = 0; i < len; i++) {

        isCheckedLeft = false;
        for (j = i - 1; j >= 0; j--) {
            if (a[i] == a[j]) {
                isCheckedLeft = true;
                break;
            }
        }
        if (isCheckedLeft) {
            continue;
        }

        for (j = i + 1; j < len; j++) {

            isCheckedRight = false;
            for (h = j - 1; h > i; h--) {
                if (a[j] == a[h]) {
                    isCheckedRight = true;
                    break;
                }
            }
            if (isCheckedRight) {
                continue;
            }

            System.out.print("("+a[i]+", "+a[j]+") ");
            if (a[i] + a[j] <= k) {
                counter++;
            }
        }
    }
    return counter;
}