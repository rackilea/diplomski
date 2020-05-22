ICsvBeanReader mockedBeanReader = mock(CsvBeanReader.class);
Book book1 = new Book();
Book book2 = new Book();
Book book3 = new Book();
when(mockedBeanReader.getHeader(true))
    .thenReturn(new String[]{"here", "is", "header"});
when(mockedBeanReader.read(Book.class, header, processors))
    .thenReturn(book1)
    .thenReturn(book2)
    .thenReturn(book3);