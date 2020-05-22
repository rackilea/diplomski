import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    public Dogs createDogs() {
        return new Dogs();
    }

    @XmlElementDecl(name = "dog")
    public JAXBElement<DogType> createDog(DogType value) {
        return new Dog(value);
    }

    @XmlElementDecl(name = "fido", substitutionHeadName = "dog", substitutionHeadNamespace = "")
    public JAXBElement<DogType> createFido(DogType value) {
        return new JAXBElement<DogType>(new QName("fido"), DogType.class, value);
    }

    @XmlElementDecl(name = "barks", substitutionHeadName = "dog", substitutionHeadNamespace = "")
    public JAXBElement<DogType> createBarks(DogType value) {
        return new JAXBElement<DogType>(new QName("barks"), DogType.class, value);
    }

}