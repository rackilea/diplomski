package generated;

import java.util.Double;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Double>
{


    public Double unmarshal(String value) {
        return (Converter.fromString(value));
    }

    public String marshal(Double value) {
        return (Converter.toString(value));
    }

}