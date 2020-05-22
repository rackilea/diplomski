public void processOne(int nProcs, int nTasks, int[] assignment) {
    /* ... */
}

public void checkAll(int nProcs, int nTasks) {
    long count = power(nProcs, nTasks);
    /* Iterate over all the possible assignments */
    for (long j = 0; j < count; j++) {
        int[] assignment = new int[nTasks];
        for (int i = 0; i < nTasks; i++)
            assignment[i] = (int) (j / power(nProcs, i) % nProcs);
        processOne(nProcs, nTasks, assignment);
    }
}