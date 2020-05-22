public static <T> T get(Queue<T> queue, int index) {
    synchronized (queue) {
        if (queue == null) {
            return null;
        }

        int size = queue.size();
        if (index < 0 || size < index + 1) {
            return null;
        }

        T element = null;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                element = queue.remove();
            } else {
                queue.add(queue.remove());
            }
        }

        return element;     
    }
}