@XmlRootElement
public class Countries {
    @XmlElement
    Country country;
}


import javax.xml.bind.annotation.XmlAttribute;

public class Country {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private String states;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStates() {
        return states;
     }
     public void setStates(String states) {
        this.states = states;
    }


    @Override
    public String toString() {

        return "Country[@name="+getName()+"][@states="+getStates();
    }
}