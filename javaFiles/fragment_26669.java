package forum15772478;

import javax.xml.bind.annotation.*;

@XmlType(namespace="http://mycompany/passenger")
public class Passenger {

    private String ticketNumber;

    @XmlElement(name="TicketNumber")
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

}