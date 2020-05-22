@XmlRootElement(name = "characteristics")
public class Characteristics {

    private final List<Characteristic> characteristics = new LinkedList<Characteristic>();

    @XmlElementRef(name = "characteristic")
    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

}