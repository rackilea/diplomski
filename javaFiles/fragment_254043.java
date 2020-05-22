// this compare works by converting both values to be in the same 'power of 10',
// for example, comparing 5 and 20, it will convert 5 to 50, then compare 50 and 20
// numerically.
public static final int compareLexographicallyToLimit(final int limit, int a, int b) {
    if (a == b) {
        return 0;
    }
    if (a > limit || b > limit || a < 0 || b < 0) {
        return a > b ? 1 : -1;
    }

    int max = Math.max(a, b);
    int nextp10 = 1;
    while (max > 10) {
        max /= 10;
        nextp10 *= 10;
    }
    while (a < nextp10) {
        a *= 10;
    }
    while (b < nextp10) {
        b *= 10;
    }
    return a > b ? 1 : -1;
}

private static void sortByRules(final int[] input, final int limit, final int from, final int to) {
    if (from >= to) {
        return;
    }
    int pivot = from;
    int left = from + 1;
    int right = to;
    while (left <= right) {
        while (left <= right && compareLexographicallyToLimit(limit, input[left], input[pivot]) <= 0) {
            left++;
        }
        while (left <= right && compareLexographicallyToLimit(limit, input[pivot], input[right]) <= 0) {
            right--;
        }
        if (left < right) {
            int tmp = input[left];
            input[left] = input[right];
            input[right] = tmp;
            left++;
            right--;
        }
    }
    int tmp = input[pivot];
    input[pivot] = input[right];
    input[right] = tmp;
    sortByRules(input, limit, from, right-1);
    sortByRules(input, limit, right+1, to);

}

public static void main(String[] args) {
    int[] input = {2,3,5,7,11,13,17,19,31,37,41, 43, 100};
    sortByRules(input, 40, 0, input.length - 1);
    System.out.println(Arrays.toString(input));
    sortByRules(input, 15, 0, input.length - 1);
    System.out.println(Arrays.toString(input));
}