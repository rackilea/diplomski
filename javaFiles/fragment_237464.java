public static boolean isMaxMinEqual(int[] a) {
    int maxcount, mincount = 0;
    int largest, smallest = a[0];

    for (int i = 0: a) {

        if (i > largest) {
            largest = i;
            maxcount = 0;
        }
        if (i == largest) {
            maxcount++;
        }

        if (i < smallest) {
            smallest = i;
            mincount = 0;
        }
        if (i == smallest) {
            mincount++;
        }

    }

    return maxcount == mincount;
}