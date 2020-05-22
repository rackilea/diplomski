@Entity  
public class Project {

    @Id
    public Long id;

   @OneToMany(mappedBy="project")
   public List<SubProject> subprojects;
}