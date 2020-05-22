public String toString(){
    return "Book title: " + bookName +
           "\nISBN: " + ISBN + 
           "\nPrice: " + price +
           "\nAuthor: " + Arrays.toString(authorsList);  
}
public static void main(String[] args) {          
    Books book1 = new Books("Harry Potter","12345", 10, new String[]{"J. K. Rowling"});
    System.out.println(book1.toString()); 
}