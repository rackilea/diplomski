int[] array = new int[21];
int nextIndex = 0;

public void push(int e) {
    array[nextIndex] = e;
    ++nextIndex;
}

public int pop() {
    --nextIndex;
    return array[nextIndex];
}