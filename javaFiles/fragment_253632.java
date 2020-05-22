public class Queue2<T> {

    public Queue2(int capacity) {   

        Queue2<T>.Node2[] slots2 =  new Queue2.Node2[capacity];     
    }


    private class Node2 
    {
        private T item;
        ReentrantLock lock = new ReentrantLock();

        public Node2(Object object) {}
        void lock() {lock.lock();}
        void unlock() {lock.unlock();}
    }
}