@Entity
@Table(name = "board")
public class Board {
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "userid")
    private User user;

    @OneToMany(mappedBy = "board")
    private Set<Card> cards;
}