public class Book extends TableServiceEntity {
    String name;
    String author;
    String description;

    public Book(){}

    public Book(String sn, String name, String author, String description) {
        this.partitionKey = "Books";
        this.rowKey = sn;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    // Setter & Getter methods for properties
    ..............
}