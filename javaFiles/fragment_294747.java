public class Catalog {

    @XmlElementWrapper(name="books")
    @XmlElement(name="book")
    public List<Book> books;

}

public class Book {

    @XmlAttribute
    public String id;
    public String author;
    public String title;
    public String genre;
    public BigDecimal price;
    @XmlElement(name="publish_date")
    public XMLGregorianCalendar publishDate;
    public String description;
}