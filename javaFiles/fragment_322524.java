public class Author {
    public Collection<Book> getBooks() {
        if (this.authorships != null) {
            return this.authorships.getBooks();
        }
        return null;    
    }
}