public class BookInventory  implements Comparable<BookInventory> {

  // code

  public int compareTo(BookInventory other){
    return bookTitle.compareTo(other.bookTitle);
  }

  //code
}