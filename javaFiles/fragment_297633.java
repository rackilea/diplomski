public void enqueue(T element) {
    if (front == (rear + 1) % queue.length) {
        expandCapacity();
    }
    queue[rear] = element;
    rear = (rear + 1) % queue.length;
}