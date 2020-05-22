import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Guests {
    private String name;
    private String drinkType;

    public Guests(){}

    public void setGuestName(String name) {this.name = name;}

    @XmlAttribute(name = "name")
    public String getGuestName() {return name;}

    @XmlElement(name = "drink")
    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }
}