package forum11333165;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlElement(name="Name")
    private String name;

    @XmlElement(name="PostalAddress")
    private PostalAddress postalAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostalAddress getPostalAddress() {
        if(null == postalAddress) {
            return new PostalAddress();
        }
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

}