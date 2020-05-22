@Entity 
public class EntityA extends Model {
    @Id
    private String ID;

    @OneToMany(mappedBy="entityA")
    public List<EntityB> listEntitesB; 

    public static Finder<String,EntityA> find = new Finder<String,EntityA>(
        String.class, EntityA.class
    ); 

    public EntityA() {
        ID = UUID.randomUUID().toString();
    }

    public String getID() {
        return ID;
    }
}