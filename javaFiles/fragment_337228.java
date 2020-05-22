@Override
public String toString() {
    String stg = getBookID() + '\t' + getTitle() 
        + addSpaces(title, 30) + getAuthor() 
        + addSpaces(author, 30) + getGenre() 
        + addSpaces(genre, 15) + getStatus() 
        + addSpaces(status, 5) + getLocation() 
        + addSpaces(Location, 20) + getCondition();
    return stg;
}