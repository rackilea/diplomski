Queue<LinkedList<T>> queue = new LinkedList<>();
queue.add(new LinkedList<>(Collections.singleton(start)));

while (!queue.isEmpty()) {
    LinkedList<T> path = queue.poll();
    T v = path.getLast();
    if (v.equals(end)) {
        return path;
    }

    for (int i = 0; i < this.keyToVertex.get(v).successors.size(); i++) {
        T v2 = this.keyToVertex.get(v).successors.get(i).key;
        if (visited.contains(v2)) {
            continue;
        }

        LinkedList<T> path2 = new LinkedList<>(path);
        path2.add(v2);
        queue.add(path2);
        visited.add(v2);
    }
}