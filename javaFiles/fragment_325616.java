@XmlRootElement
@XmlSeeAlso({Book.class})
public class Books extends ArrayList<Book> {
  public Books() {
    this.add(new Book("The Sign of the Four"));
  }

  @XmlElement(name = "book")
  public List<Book> getBooks() {
    return this;
  }
}