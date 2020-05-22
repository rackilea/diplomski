public class Cat {
    private static int myval;

    Cat() throws IOException {
        this.myval = 7;
        System.out.println("Called constructor");
    }

    public static void main() {
        try {
            Cat cat = new Cat()
        } catch (IOException e) {
            // do stuff with e
        }
    }
}