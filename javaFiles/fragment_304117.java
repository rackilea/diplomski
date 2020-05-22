@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name = "characteristic")
    public JAXBElement<String> createCharacteristic(String value) {
        return new Characteristic(value);
    }

}