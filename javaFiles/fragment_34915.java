@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;

    private String ticketNo;
    private Date releasedDate;
    private boolean printed;

    // getters and setters
}

@Entity
public class Discount {
    @Id
    @GeneratedValue
    private Long id;

    private String percentage;
    private Date releasedDate;
    private boolean printed;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "TICKET_ID")  // you can rename the join column 
    private Ticket ticket;

    // getters and setters
}