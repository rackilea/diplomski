import java.util.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "listOfDogs")
public class Dogs {

    private List<JAXBElement<DogType>> dogs = new LinkedList<JAXBElement<DogType>>();

    @XmlElementWrapper(name = "dogs")
    @XmlElementRef(name = "dog")
    @XmlJavaTypeAdapter(DogAdapter.class)
    public List<JAXBElement<DogType>> getDogs() {
        return this.dogs;
    }

    @Override
    public String toString() {
        return "Dogs [dogs=" + dogs + "]";
    }

}