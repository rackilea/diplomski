@Entity 
public class RegUsers extends Model{

    public static Finder<Long,RegUsers> find = new Finder<Long,RegUsers>(Long.class, RegUsers.class);

    @Id
    public Long id;

    public String email;
    public String name;

    @OneToMany(mappedBy="regUsers")
    public Set<RegId> regIds;
}