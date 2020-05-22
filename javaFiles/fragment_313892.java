package forum11333165;

import javax.xml.bind.annotation.XmlElement;

public class PostalAddress {

    private String state;

    @XmlElement(name="State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}