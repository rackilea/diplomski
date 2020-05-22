public Iterator<T> iterator() {

    ArrayList<T> a = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
        Collections.addAll(a, matrix[i]);
    }
    return (Iterator<T>) (a.iterator());
}