@ManagedBean
@ViewScoped
public class TicketController {
    private Long id;
    private Ticket ticket;

    @EJB
    private TicketEJB ticketEJB;

    public void preLoad() {
        ticket = ticketEJB.getTicketById(id);
    }

    public String doUpdateTicket() {
        ticketEJB.updateTicket(ticket);
        return "view.faces";
    }

    // ...
}