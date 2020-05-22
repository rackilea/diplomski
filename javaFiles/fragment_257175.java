package xxe;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}