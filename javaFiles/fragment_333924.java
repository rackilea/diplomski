@Entity
class Ticket {
    @Id
    private Integer id;

    // ...

    @OneToMany(mappedBy="ticket", fetch=FetchType.LAZY)
    private List<TicketNotes> notes;
}


@Entity
@Inheritence
@DiscriminatorColumn(name="PARENT_TYPE")
public abstract class Note {
    @Id
    private Integer id;

    // ...
}

@Entity
@DiscriminatorValue("ticket")
public class TicketNote extends Note {
    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    private Ticket ticket;
}