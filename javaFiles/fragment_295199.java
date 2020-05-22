import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Foo {

    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

    @XmlElement(name="vehicle")
    public List<Vehicle> getVehicles() {
        return vehicles;
    }


}