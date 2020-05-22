import javax.xml.bind.*;
import javax.xml.bind.annotation.adapters.*;

public class DogAdapter extends XmlAdapter<JAXBElement<DogType>, JAXBElement<DogType>> {

    @Override
    public JAXBElement<DogType> unmarshal(JAXBElement<DogType> v) throws Exception {
        return new Dog(v.getName().getLocalPart(), v.getValue());
    }

    @Override
    public JAXBElement<DogType> marshal(JAXBElement<DogType> v) throws Exception {
        return v;
    }

}