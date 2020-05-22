@Entity
@Table(name="Events")
public class Events {

    //....................

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Events")
    private Set<Votes> votes = new HashSet<>();

}