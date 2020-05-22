@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Rankable extends Model {
    @ManyToOne(cascade = CascadeType.ALL)
    public User creator;

    public String name;

    @ManyToMany()
    public Set<Tag> tags;
}