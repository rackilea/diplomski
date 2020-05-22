@Entity
public class Tag extends Model {
    public String name;
    public String description;

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
    public Set<Rankable> rankables;
}