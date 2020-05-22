public class Employee {
    // Class members and other stuff as you have them already go here...

    @Override
    public String toString() {
        // Override the default toString() method and return a custom String instead.
        return String.format("%s\t%s\t%s", first, last, money);
    }
}