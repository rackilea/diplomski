@Entity
@Table(name="project_manager")
public class ProjectManager{

    @OneToMany(mappedBy="projectManager")
    private List<Project> projects = new ArrayList<>();

}

@Entity
@Table(name="project")
public class Project {

    @ManyToOne
    @JoinColumn(name = "project_manager_id")
    private ProjectManager projectManager;
}