public static void main(String[] args) {
    final AtomicReference<String> value = new AtomicReference<String>("hello");

    System.out.println(value); // prints "hello"

    new Runnable() {
        public void run() { value.set("goodbye"); }
    }.run();

    System.out.println(value); // prints "goodbye"
}