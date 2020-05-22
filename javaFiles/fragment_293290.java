@XmlRootElement(name = "name")
public class Name {

    private String value;

    public void setValue(String value){

        this.value = value;
    }

    @XmlAttribute
    public String getValue(){

        return value;

    }

}