import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder = { "author", "description","title", "genre","price", "date"} )
@XmlRootElement( name = "Book" )
public class Book
{
    String author;
    String description;
    String title;
    String genre;
    String price;
    String date;

    public String getAuthor() {
        return author;
    }

    @XmlElement( name = "author" )
    public void setAuthor( String author )
    {
        this.author = author;
    }



    public String getDescription() {
        return description;
    }

    @XmlElement( name = "description" )
    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement( name = "title" )
    public void setTitle( String title )
    {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    @XmlElement( name = "genre" )
    public void setGenre( String genre )
    {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    @XmlElement( name = "price" )
    public void setPrice( String price )
    {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    @XmlElement( name = "date" )
    public void setDate( String date )
    {
        this.date = date;
    }

}