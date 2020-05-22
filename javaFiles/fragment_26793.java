public class Book {

private static int i = 0;
private int bookNumber;

public Book(int bookNumber) {
    i++;
    /* this.bookNumber means "the variable of the currently in creation book object instance)
     * you only need it if its not clear because there is a local variable with the same name 
     */
    this.bookNumber = bookNumber;
}

// a second (default) constructor in case you want to create book objects and dont yet know the number of it
// after creation you can use the get/set values to access the variable from "outside"
public Book(){
    i++;
}

@Override
public String toString() {

    StringBuilder result = new StringBuilder();

    // Here you dont need this because there is no local variable bookNumber
    // You can however always use it when referencing such object variables 
    result.append("Book " + bookNumber + " of " + i + " books in total");

    return result.toString();
}

public int getBookNumber(){
    return bookNumber;
}

public void setBookNumber(int bookNumber){
    this.bookNumber = bookNumber;
}
}