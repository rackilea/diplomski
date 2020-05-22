public static void main(String... ignored) {
    caller(10, 7, new Callback<int[]>() {
        @Override
        public void on(int[] ints) {
            System.out.println(Arrays.toString(ints));
        }
    });
}

interface Callback<T> {
    public void on(T t);
}

public static void caller(int maxSum, int dimensions, Callback<int[]> callback) {
    int[] ints = new int[dimensions];
    for (int t = 0; t < maxSum; t++) {
        caller(t, 0, ints, callback);
    }
}

private static void caller(int sum, int idx, int[] ints, Callback<int[]> callback) {
    if (idx == ints.length) {
        callback.on(ints);
        return;
    }
    for (int i = 0; i < sum; i++) {
        ints[idx] = i;
        caller(sum - i, idx+1, ints, callback);
    }
}