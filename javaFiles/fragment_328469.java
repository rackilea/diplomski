@Entity
@Table(name = "table")
public class Parameters{

    @Id
    int id;

    @Column(name = "a")
    String a;
}