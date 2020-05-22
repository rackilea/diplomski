package forum9268074;

import java.sql.Date;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Foo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {
    int i;

    @XmlJavaTypeAdapter(SqlDateAdapter.class)
    Date d; //java.sql.Date does not have a no-arg constructor
}