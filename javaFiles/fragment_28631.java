public Map<Bookstore, List<Book>> get15BooksFromGuidesCategory() {
   return get15BooksFrom(guidesCategoryEmpikURL, guidesCategoryMerlinURL)
}

public Map<Bookstore, List<Book>> get15BooksFromBiographiesCategory() {
   return get15BooksFrom(biographiesCategoryEmpikURL, biographiesCategoryMerlinURL)
}

public Map<Bookstore, List<Book>> get15BooksFrom(String bookStoreEmpikURL, String bookStoreMerlinURL) {

    bookstoreWith15CategorizedBooks.put(Bookstore.EMPIK, empikBookService
            .get15BooksFromCategory(connect(bookStoreEmpikURL)));
    bookstoreWith15CategorizedBooks.put(Bookstore.MERLIN, merlinFetchingBookService
            .get15BooksFromCategory(connect(bookStoreMerlinURL)));

    return bookstoreWith15CategorizedBooks;
}