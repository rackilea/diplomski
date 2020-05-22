@Entity
public class Ticket {
  /* other attributes */

  @OneToMany(mappedBy = "ticket")
  private List<TicketEntry> entries;
}

@Entity
public class TicketEntry {
  /* other attributes */

  @ManyToOne
  private Ticket ticket;
}