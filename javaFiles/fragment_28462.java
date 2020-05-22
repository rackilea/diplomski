@Test
public void getBooksByCategory() {

    List<Book> empikBestsellers = EmpikBookProvider.prepare5Bestsellers();
    List<Book> merlinBestsellers = MerlinBookProvider.prepare5Bestsellers();

    BookServiceSource bookServiceSource1 = Mockito.mock(BookServiceSource.class);
    Mockito.when(bookServiceSource1.getName()).thenReturn(Bookstore.EMPIK);
    Mockito.when(bookServiceSource1.getBooksByCategory(CategoryType.CRIME)).thenReturn(empikBestsellers);   

    BookServiceSource bookServiceSource2 = Mockito.mock(BookServiceSource.class);
    Mockito.when(bookServiceSource2.getName()).thenReturn(Bookstore.MERLIN);
    Mockito.when(bookServiceSource2.getBooksByCategory(CategoryType.CRIME)).thenReturn(merlinBestsellers);      

    List<BookServiceSource> sources = new ArrayList<>();
    sources.add(bookServiceSource1);
    sources.add(bookServiceSource2);

    BookService service = new BookService(sources);
    Map<Bookstore, List<Book>> actualMap = service.getBooksByCategory(CategoryType.CRIME);

    // compare result
}