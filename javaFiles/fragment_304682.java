public void displayBooksFromAuthor(String author) {
    for(Book b : bookList) {
        if(b.getAuthor().equals(author))
            System.out.println(b);
    }
}