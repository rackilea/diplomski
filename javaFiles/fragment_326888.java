List<Book> books = Arrays.asList(
        new Book(1, 2),
        new Book(1, 3),
        new Book(2, 2),
        new Book(2, 3)
);

System.out.println(
    books.stream()
            .collect(
                    groupingBy(Book::getID,
                        maxBy(comparingInt(Book::getRevison))
                    )
            )

);// {1=Optional[Book{ID=1, revison=3}], 2=Optional[Book{ID=2, revison=3}]}