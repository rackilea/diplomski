import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class DefaultSettings {

    private List<Groups> groups = new ArrayList<Groups>();

    @XmlAnyElement
    @XmlJavaTypeAdapter(GroupsAdapter.class)
    public List<Groups> getGroups() {
        return groups;
    }

}