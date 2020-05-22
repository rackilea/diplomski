void addbooktype(Books book) {

    System.out.println("You chose: " + book.type);
    System.out.println("Adding to the list...");

    booklist[bookcounter++] = book;
}