private Vertex<V> remove(List<Vertex<V>> queue) {//Q = Q - {v}
    if (queue.isEmpty()) {
        return null;
    }
    int ix = 0;
    int min = distances.get(queue.get(0));
    for (int i = 1; i < queue.size(); ++i) {
        int dist = distances.get(queue.get(i));
        if (dist < min) {
            ix = i;
            min = dist;
        }
    }
    return queue.remove(ix);
}