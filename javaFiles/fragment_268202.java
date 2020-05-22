System.out.println("Start loading/synchronizing books");
loadAllBooks();

System.out.println("Creating adapter");
BooksAdapter  adapter = new BooksAdapter  (this, booksList);

public void onChildAdded (DataSnapshot bookNode, String previousChild){
    System.out.println("Adding book to list");
    BookItem bookItemModel = bookNode.getValue(BookItem.class);
    booksList.add(bookItemModel);
}