import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    String street;

    public Address() {
    }

    public Address(String street) {
        this.street = street;
    }

}