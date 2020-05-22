import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Books")
public class Books {

    List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    @XmlElement( name = "Book" ) 
    public void setBooks( List<Book> books ) 
    { 

        this.books = books; 

    } 

}