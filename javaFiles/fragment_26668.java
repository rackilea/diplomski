package forum15772478;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Train")
public class Train {

    private List<Passenger> passengers;

    @XmlElementWrapper(name="Passengers")
    @XmlElement(name="Passenger")
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}