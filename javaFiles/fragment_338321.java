public static void main(String[] args) {

    Object lock = new Object();
    synchronized (lock) {
        System.out.println("hello");
    }
}