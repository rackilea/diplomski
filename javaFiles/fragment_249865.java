package forum11894193;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StringAdapter extends XmlAdapter<String, String> {

    @Override
    public String marshal(String string) throws Exception {
        if("".equals(string)) {
            return null;
        }
        return string;
    }

    @Override
    public String unmarshal(String string) throws Exception {
        return string;
    }

}