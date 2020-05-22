@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 3287868602749718327L;

    @EmbeddedId
    private TicketId ticketId;

    @ManyToOne
    @MapsId("idGameFk")
    @JoinColumn(name = "id_game_fk")
    private Games games;

    @ManyToOne
    @MapsId("idClientFk")
    @JoinColumn(name = "id_client_fk")
    private Client client;

    ....
}