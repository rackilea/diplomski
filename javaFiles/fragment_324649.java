@Entity 
public class MiniProject {

    @Id
    public Long id;

    @ManyToOne
    public SubProject subproject;
}