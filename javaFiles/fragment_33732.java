doInJPA(entityManager -> {

    EmbeddedKey key = new EmbeddedKey();
    key.setGroupNo(1);

    Book book = new Book();
    book.setBookName( "High-Performance Java Persistence");

    book.setKey(key);

    entityManager.persist(book);
});

doInJPA(entityManager -> {
    EmbeddedKey key = new EmbeddedKey();

    key.setGroupNo(1);
    key.setRowId(1L);

    Book book = entityManager.find(Book.class, key);
    assertEquals( "High-Performance Java Persistence", book.getBookName() );
});