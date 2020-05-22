Class A implements Runnable {

    public void run() {

        // create shared set instance scoped to A, and make it thread-safe
        Set col = Collections.synchronizedSet(new HashSet());

        B b1 = new B(col);
        Thread t11 = new Thread(b1);
        t11.start();

        B b2 = new B(col);
        Thread t21 = new Thread(b2);
        t21.start();
    }
}

Class B implements Runnable {

    private final Set<T> someSet;

    private B(Set<T> someSet) {
      this.someSet = someSet;
    }

    public void method(final T obj) {
        someSet.add(obj);
    }

    public void run() {
        method()
    }
}