public static void main(String[] args) {
        Book book1 = new Book(10,"a");
        Book book2 = new Book(11,"b");
        Book book3 = new Book(20,"c");
        Book book4 = new Book(20,"d");
        Book book5 = new Book(11,"e");

        PriorityQueue<Book> bookQueue = new PriorityQueue<Book>();
        bookQueue.add(book1);
        bookQueue.add(book2);
        bookQueue.add(book3);
        bookQueue.add(book4);
        bookQueue.add(book5);

        while(!bookQueue.isEmpty()){
            Book book = bookQueue.poll();
            System.out.println(book.title + " - " + book.weight);
        }
    }