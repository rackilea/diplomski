import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws JAXBException {
        String xml = "<owner><dog></dog></owner>";
        JAXBContext jaxbContext = JAXBContext.newInstance(Owner.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Owner owner = (Owner) jaxbUnmarshaller.unmarshal(
                new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));

        System.out.println(owner.getAnimal().getClass());
    }
}

abstract class Animal {}

class Dog extends Animal {}

class Cat extends Animal {}

class Lion extends Animal {}

@XmlRootElement
class Owner {
    @XmlElements({
            @XmlElement(name = "dog", type = Dog.class),
            @XmlElement(name = "cat", type = Cat.class),
            @XmlElement(name = "lion", type = Lion.class)
    })
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }
}