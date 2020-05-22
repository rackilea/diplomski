class Main {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.c1.f(99);
    }

    static int counter = 1;

    // Want to pass counter to Cups constructor here:
    static Cups x = new Cups(counter);

    // Want to increment that counter here
    static Cups y = new Cups(counter);

    // Want to increment that counter here
    static Cups z = new Cups(counter);

}

Cups(int counter) {
    System.out.println("Cups() constructor #" + counter);
    Main.counter++;
 }