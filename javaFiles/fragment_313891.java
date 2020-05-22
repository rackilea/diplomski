package forum11333165;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Address")
public class Address {

    private String name;
    private PostalAddress postalAddress;

    @XmlElement(name="Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="PostalAddress")
    public PostalAddress getPostalAddress() {
        if(null == postalAddress) {
            postalAddress = new PostalAddress();
        }
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

}