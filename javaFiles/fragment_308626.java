import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class UdtTextType {

    @XmlValue
    protected String value;

    public void setValue(String value) {
        this.value = value;
    }

}