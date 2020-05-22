import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Film")
public class Film {
    private String film_id;
    private String title;
    private String description;
    private String length;
    private String image_id;
    private Image image;
}