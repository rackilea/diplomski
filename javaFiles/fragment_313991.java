@Entity public class Author {
    @OneToMany(mappedBy="author")
    public List<Book> getBooks() {
        return books;
    }
...
}

@Entity public class Book {
    public String getName() {
        return bookName;
    }

    @ManyToOne
    public Author getAuthor() {
        return author;
    }
    ...
}