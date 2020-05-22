@Override
public void remove(IBookItem book) throws BookStoreException{

boolean itemFound = false;

for(Iterator<BookEntry<String, ArrayList<BookItem>>> it = titleMap.iterator(); it.hasNext();){
    BookEntry<String, ArrayList<BookItem>> bookEntry = (BookEntry<String,ArrayList<BookItem>>)it.next();
    if(bookEntry.getValue().equals(book.getTitle())){
        itemFound  = true;
        bookEntry.getValue().remove(book);
        titleMap.remove();
        System.out.println("book Removed (via titleMap): " + book);
    }
}

//here other loops

if (!itemFound){
    throw new BookStoreException("Item not found!");
}}