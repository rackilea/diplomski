import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlJavaTypeAdapter(RootAdapter.class)
@XmlType(propOrder={"name", "child"})
public class Root {

    private String name;
    private Root child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Root getChild() {
        return child;
    }

    public void setChild(Root report) {
        this.child = report;
    }

}