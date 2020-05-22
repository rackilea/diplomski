package forum15772478;

import javax.xml.bind.annotation.*;

public class Passenger {

    private String ticketNumber;

    @XmlElement(
        namespace="http://mycompany/passenger",
        name="TicketNumber")
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

}