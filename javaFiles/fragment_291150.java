public void rentBook() {
    System.out.println("Rent a book:");
    System.out.println("Enter the title of a book you want to rent: ");
    String name = "Jurassic Park";
    Optional<Book> book = booksAvailable.stream().filter(b -> b.name.equals(name)).findFirst();
    if(book.isPresent()) {
        System.out.println("Renting " + name);
        booksAvailable.remove(book.get());
        booksRented.add(book.get());
    }
    else
        System.out.println("No such book found");
}