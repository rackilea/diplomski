package forum11353790;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address implements Serializable {

    private String  street;
    private String  city;
    private String  state;
    private String  country;
    private String  postalcode;
    private Integer addresstype;

}