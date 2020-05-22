Set<Book> hs1 = new HashSet<Book>();
    Set<Book> hs2 = new HashSet<Book>();

    hs1.add(new Book("book1", 10, 10));
    hs1.add(new Book("book2", 20, 20));

    hs2.add(new Book("book3", 30, 30));
    hs2.add(new Book("book1", 40, 40));

    hs2.addAll(hs1);