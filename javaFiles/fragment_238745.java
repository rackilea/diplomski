System.out.println("All info for the first book: \n");

    System.out.println("Name: " + book1.getName());
    System.out.println("ISBN: " + book1.getIsbn());
    for (String author : book1.getAuthors()) {
        System.out.println("Author: " + author);
    }