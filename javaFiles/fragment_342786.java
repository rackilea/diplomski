@Entity
@Table(name = "card")
public class Card {

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "boardid")
    private Board board;

}