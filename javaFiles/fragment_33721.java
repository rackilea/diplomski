private A[] a = new A[2];
public A getItem() {
    return a[new Random().nextInt(1)];
}
public A getItem(int index) {
    return a[index];
}