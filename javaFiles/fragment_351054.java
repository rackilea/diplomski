private static LinkedList[] bucket = new LinkedList[19];

static {
    for (int i = 0; i < bucket.length; ++i) {
        bucket[i] = new LinkedList();
    }
}