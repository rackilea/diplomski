import java.util.Map;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;

public class CNode {

    private Map<QName, String> extension;

    @XmlAnyAttribute
    public Map<QName, String> getExtension() {
        return extension;
    }

    public void setExtension(Map<QName, String> extension) {
        this.extension = extension;
    }

}