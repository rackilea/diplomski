import java.util.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
public abstract class Wrapper<T> extends ElementRoot {

    protected int totalSize;

    protected List<T> collection = new ArrayList<>();

    @XmlElement
    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public abstract List<T> getCollection();

}