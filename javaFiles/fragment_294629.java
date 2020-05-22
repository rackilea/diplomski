import com.sun.xml.bind.marshaller.*;

public class MyNamespacePrefixMapper extends NamespacePrefixMapper {

    @Override
    public String getPreferredPrefix(String arg0, String arg1, boolean arg2) {
        return null;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris2() {
        return new String[] {"ns1", "http://www.example.com/FOO", "ns2", "http://www.example.com/BAR"};
    }


}