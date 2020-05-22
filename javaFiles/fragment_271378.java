import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class HistoricalData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1284437498477880205L;

    private List<Data> data;

    @XmlElementWrapper(name="HistoricalData")
    @XmlElement(name = "Data")
    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

}