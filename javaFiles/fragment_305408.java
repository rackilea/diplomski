import java.math.BigDecimal;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class NumberAdapter extends XmlAdapter<String, Number> {

    @Override
    public Number unmarshal(String v) throws Exception {
        return new BigDecimal(v);
    }

    @Override
    public String marshal(Number v) throws Exception {
        return v.toString();
    }

}