import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
     // Instance Variables
    private String name;
    private String address_line1;
    private String address_line2;
    private String address_city;
    private int address_postcode;
    private String address_state;
    private String address_country;
    private String primary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public int getAddress_postcode() {
        return address_postcode;
    }

    public void setAddress_postcode(int address_postcode) {
        this.address_postcode = address_postcode;
    }

    public String getAddress_state() {
        return address_state;
    }

    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }

    public String getAddress_country() {
        return address_country;
    }

    public void setAddress_country(String address_country) {
        this.address_country = address_country;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return "Person{" 
                + "\n      name=" + name 
                + "\n      address_line1=" + address_line1 
                + "\n      address_line2=" + address_line2 
                + "\n      address_city=" + address_city 
                + "\n      address_postcode=" + address_postcode 
                + "\n      address_state=" + address_state 
                + "\n      address_country=" + address_country 
                + "\n      primary=" + primary 
                + "\n    }";
    }
}