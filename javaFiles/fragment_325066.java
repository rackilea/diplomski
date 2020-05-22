public static Pair<Integer, Integer> calculate(int numberOfTasks, int oldWorkerValue, int youngWorkerValue) {
    int m = Integer.MAX_VALUE; // minimal value
    int o = 0; // old workers
    int n = 0; // new workers
    for (int i = 1; i <= (int)Math.ceil((double) numberOfTasks / oldWorkerValue); i++) {
        int nw = (int) Math.ceil((double)(numberOfTasks - i * oldWorkerValue) / youngWorkerValue);
        if (nw < 0) nw = 0;
        int tm = i * oldWorkerValue + nw * youngWorkerValue;
        if (tm < m) {
            m = tm; o = i; n = nw;
        }
    }
    return new Pair<>(o, n); // pair <old workers, new workers>
}