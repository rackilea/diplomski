private final List<T> data = new ArrayList<T>();

public synchronized void method1() {
    for (T item : data) {
        // ..
    }
}

public void method3() {
    data.clear();
}