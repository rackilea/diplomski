import java.util.*;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Groups {

    private List<Instruments> instruments = new ArrayList<Instruments>();

    @XmlAnyElement
    @XmlJavaTypeAdapter(InstrumentsAdapter.class)
    public List<Instruments> getInstruments() {
        return instruments;
    }

}