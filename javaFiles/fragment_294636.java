import java.util.Map;
import java.util.Map.Entry;
import com.sun.xml.bind.marshaller.*;

public class MyNamespacePrefixMapper extends NamespacePrefixMapper {

    private String[] namespaces;

    public MyNamespacePrefixMapper(Map<String, String> namespaces) {
        this.namespaces = new String[namespaces.size() * 2];
        int index = 0;
        for(Entry<String, String> entry : namespaces.entrySet()) {
            this.namespaces[index++] = entry.getKey();
            this.namespaces[index++] = entry.getValue();
        }
    }

    @Override
    public String getPreferredPrefix(String arg0, String arg1, boolean arg2) {
        return null;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris2() {
        return namespaces;
    }

}