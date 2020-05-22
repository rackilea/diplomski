void nestedLoopOperation(int[] counters, int[] length, int level) {
    if(level == counters.length) performOperation(counters);
    else {
        for (counters[level] = 0; counters[level] < length[level]; counters[level]++) {
            nestedLoopOperation(counters, length, level + 1);
        }
    }
}