import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="ProductImage")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ProductImage", propOrder = {
    "url"
})
public class Image {

    public Image(){}

    private String url;

    public Image( String url) {   
        this.url = url;
    }

    @XmlElement(name = "ImageLocation")
    public String getUrl() {
        return this.url;
    }
}