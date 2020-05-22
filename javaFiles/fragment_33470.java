PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder())

List<Integer> keysGreaterOrEqualTo(Integer key) {
    List<Integer> keys = new ArrayList<>();
    while(!queue.isEmpty() && queue.peek() >= key) {
        keys.add(queue.poll());
    }
    return keys;
}