public static void main(String[] args) {
    ListBook r = new ListBook();
    r.printList();
    // OR
    ListBook r2 = new ListBook(new String[]{"Book 1", "Book 2", "Book 3"});
    r2.printList();
}