import java.util.List;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlVariableNode;

@XmlAccessorType(XmlAccessType.FIELD)
public class FileDocument {

    @XmlVariableNode("source")
    protected List<Metadata> metadata;

}