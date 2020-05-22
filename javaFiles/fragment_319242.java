...
private int max; // the maximum element
private int last = Integer.MIN_VALUE; // the last element returned by next()

public ComplexIterator(int[][] lists) {
    minHeap = new PriorityQueue<IndexedArrayValue>();
    int numOfLists = lists.length;

    this.lists = lists;
    max = lists[0][lists[0].length-1];
    for (int i = 0; i < numOfLists; i++) {
        minHeap.add(new IndexedArrayValue(i, 0, lists[i][0]));
        if (lists[i][lists[i].length-1] > max) {
            max = lists[i][lists[i].length-1];
        }
    }
}

@Override
public boolean hasNext() {
    return last < max;
}

@Override
public Integer next() {
    if (!hasNext())
        throw new NoSuchElementException();

    int value;
    do {
        IndexedArrayValue indArrVal = minHeap.poll();
        int arrayId = indArrVal.arrayId;
        int index = indArrVal.index;
        value = indArrVal.value;
        int nextIndex = index + 1;

        if (nextIndex < lists[arrayId].length) {
            minHeap.add(new IndexedArrayValue(arrayId, nextIndex, lists[arrayId][nextIndex]));
        }
    }
    while (value <= last);
    last = value;

    return value;
}