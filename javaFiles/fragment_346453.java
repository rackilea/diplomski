@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="project") @OrderColumn(name = "project_index")
    List<Application> applications = new ArrayList<Application>();

    // getters, setters
}