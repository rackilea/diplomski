public static <T> void combinations(List<T> values, int maxCount, CombinationListener<T> listener) {
    List<T> comb = (List<T>) Arrays.asList(new Object[maxCount]);
    boolean[] used = new boolean[values.size()];
    combinations0(values, used, comb, 0, maxCount, listener);

}

static <T> void combinations0(List<T> values, boolean[] used, List<T> comb, int idx, int maxCount, CombinationListener<T> listener) {
    if (idx == maxCount) {
        listener.onComlination(comb);
        return;
    }
    for (int i = 0; i < values.size(); i++) {
        if (used[i]) continue;

        used[i] = true;
        comb.set(idx, values.get(i));
        combinations0(values, used, comb, idx + 1, maxCount, listener);
        used[i] = false;
    }
}

public static void main(String[] args) {
    combinations(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 5, new CombinationListener<Integer>() {
        @Override
        public void onComlination(List<Integer> list) {
            System.out.println(list);
        }
    });
}

interface CombinationListener<T> {
    void onComlination(List<T> list);
}