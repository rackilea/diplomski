TreeSet<T> set = new TreeSet<>();

public void add(T t) {
    List<T> oldHead = new ArrayList<>(set).subList(0, Math.min(set.size(), 8));
    set.add(t);
    List<T> newHead = new ArrayList<>(set).subList(0, Math.min(set.size(), 8));
    for (T e : oldHead) {
        int oldIndex = oldHead.indexOf(e);
        int newIndex = newHead.indexOf(e);
        if (oldIndex != newIndex) {
            System.out.println(e + ": " + oldIndex + "->" + newIndex);
        }
    }
}