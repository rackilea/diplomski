package forum13232991;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class AddAttr {

    @XmlJavaTypeAdapter(ValueAdapter.class)
    Object value;

}