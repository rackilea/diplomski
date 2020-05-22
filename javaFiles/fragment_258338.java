@Override
public String toString(){
    StringBuilder string= new StringBuilder();
    string.append("total number of books: ").append(bookCollection.size()).append("\n");
    string.append("number of loaned books: ").append(numberOfBooksOnLoan()).append("\n");
    return string.toString();
}