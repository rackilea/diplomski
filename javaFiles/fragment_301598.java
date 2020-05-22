public Ary(int arraySize) {
    this.arraySize = arraySize;
    this.anArray = new int[arraySize];
    for (int i = 0; i < arraySize; i++) {
        this.anArray[i] = r.nextInt(101); // <-- [0, 100], or [0, 101)
    }
}

public Ary() {
    this(5); // <-- use the other constructor.
}