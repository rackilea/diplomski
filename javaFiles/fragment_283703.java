import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

@XmlRootElement(name="Root")
public class Root {

    private Map<QName, String> extension;
    private List<CNode> cnodes;

    @XmlAnyAttribute
    public Map<QName, String> getExtension() {
        return extension;
    }

    public void setExtension(Map<QName, String> extension) {
        this.extension = extension;
    }

    @XmlElement(name="CNode")
    public List<CNode> getCnodes() {
        return cnodes;
    }

    public void setCnodes(List<CNode> cnodes) {
        this.cnodes = cnodes;
    }

}