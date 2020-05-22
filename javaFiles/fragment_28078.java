import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

public class GroupsAdapter extends XmlAdapter<JAXBElement<Groups>, Groups> {

    private int counter = 1;
    private InstrumentsAdapter instrumentsAdapter = new InstrumentsAdapter();

    public InstrumentsAdapter getInstrumentsAdapter() {
        return instrumentsAdapter;
    }

    @Override
    public Groups unmarshal(JAXBElement<Groups> v) throws Exception {
        return v.getValue();
    }

    @Override
    public JAXBElement<Groups> marshal(Groups v) throws Exception {
        instrumentsAdapter.resetCounter();
        return new JAXBElement<Groups>(new QName("groups" + counter++), Groups.class, v);
    }

}