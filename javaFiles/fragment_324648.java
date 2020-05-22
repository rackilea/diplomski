@Entity 
public class SubProject {

    @Id
    public Long id;

    @ManyToOne
    public Project project;

    @OneToMany(mappedBy="subproject") 
    public List<MiniProject> miniprojects; 
}