import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "party")

public class Party {

    @XmlAttribute(name = "date")
    private String partyDate;

    @XmlElement(name="guest")
    private Guests guests;

    public Party() {}

    public String getPartyDate() {return partyDate;}

    public void setPartyDate(String partyDate) {
        this.partyDate = partyDate;
    }

    public Guests getGuests() {
        return guests;
    }

    public void setGuests(Guests guests) {
        this.guests = guests;
    }
}