public class Catalog {
    public Books books; 
}

public class Books {
    @XmlElement(name = "book")
    public List<Book> bookList;
}