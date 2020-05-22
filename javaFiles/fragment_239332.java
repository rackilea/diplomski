import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Details")
@XmlType(propOrder = { "detailA", "detailB" })
public class Details {
    private List<String> detailA;
    private List<String> detailB;

    public void setDetailA(List<String> detailA) {
        this.detailA = detailA;
    }

    @XmlElementWrapper(name = "detail-a")
    @XmlElement(name = "detail")
    public List<String> getDetailA() {
        return detailA;
    }

    public void setDetailB(List<String> detailB) {
        this.detailB = detailB;
    }

    @XmlElementWrapper(name = "detail-b")
    @XmlElement(name = "detail")
    public List<String> getDetailB() {
        return detailB;
    }
}