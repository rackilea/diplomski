import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
//JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
@XmlAccessorType(XmlAccessType.FIELD)
public class EstateDTO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -8545841080597549468L;

    private String estateId;
    private String owner;
    private String estateName;
    private String street;
    private int number;
    private String extraAddressLine;
    private int zip;
    private String country;

    private int space;
    private List<String> tenants = new ArrayList<String>();

    public EstateDTO() {
    }

    public EstateDTO(String estateName, String street, int number, int zip, String country, int space) {
        this.estateName = estateName;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.country = country;
        this.space = space;
    }

}