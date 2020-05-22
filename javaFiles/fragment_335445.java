private static class QSortJob<T extends Comparable<T>> extends RecursiveAction {
    private final T[] arr;
    private final int left;
    private final int right;
    private final int depth;
    private final String branch;

    private QSortJob(T[] arr, int left, int right, int depth, String branch) {
        this.arr = Objects.requireNonNull(arr);
        this.left = left;
        this.right = right;
        this.depth = depth;
        this.branch = branch;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int pivotIndex = left + (right - left) / 2;
            System.out.println(String.format("Branch=%s, depth=%d, length(subarray)=%d", branch, depth, right - left + 1));

            pivotIndex = partition(pivotIndex);
            invokeAll(new QSortJob<>(arr, left, pivotIndex-1, depth + 1, "Left"),
                    new QSortJob<>(arr, pivotIndex+1, right, depth + 1, "Right"));
        }
    }