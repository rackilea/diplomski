public class Queue<T>  {

    public Queue(int capacity) {

        Queue.Node<T>[] slots = (Node<T>[]) new Node<?>[capacity];
    }   

    private static class Node<T> 
    {
        public T item;
        ReentrantLock lock = new ReentrantLock();

        void lock() {lock.lock();}
        void unlock() {lock.unlock();}
    }
}