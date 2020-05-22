package forum11353790;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement
public class Person implements Serializable {

    private String firstname;

    private String lastname;

    private List< Address > addresses = new ArrayList< Address >();

    @XmlAnyElement
    @XmlJavaTypeAdapter(MapAdapter.class)
    private Map< String, String > data = new HashMap< String, String >();

}