import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

public class InstrumentsAdapter extends XmlAdapter<JAXBElement<Instruments>, Instruments> {

    private int counter = 1;

    @Override
    public Instruments unmarshal(JAXBElement<Instruments> v) throws Exception {
        return v.getValue();
    }

    @Override
    public JAXBElement<Instruments> marshal(Instruments v) throws Exception {
        return new JAXBElement<Instruments>(new QName("instruments" + counter++), Instruments.class, v);
    }

    public void resetCounter() {
        counter = 1;
    }

}