session.beginTransaction();

// load a library with ID = 1
Library library = session.get(Library.class, 1);

// assuming that your library has two books
Book book = library.getBooks().get(0); //gets the first book
library.getBooks().remove(0); // Remove this book from the library
session.delete(book);

session.getTransaction().commit();