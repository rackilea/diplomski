private void interchangeUp() {
    int current = size - 1;
    int parent = (current - 1) / 2;

    //while (parent <= 0 && heapForm[current].compareTo(heapForm[parent]) < 0) {
    while (parent >= 0 && heapForm[current].compareTo(heapForm[parent]) < 0) {
        swap(parent, current);
        current = parent;
        parent = (current - 1) / 2;
    }
}