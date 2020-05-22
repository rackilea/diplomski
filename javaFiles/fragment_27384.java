public class BookExample {
    private static List<Book> list = new ArrayList<Book>();

    public static void main(String[] args) {
        if (list.contains(new Book("9780345917430", null, null)) {
            System.out.println("Boken finns");
        }
    }
}