@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "project"
})
@XmlRootElement(name = "projects")
public class Projects {

    protected List<Project> project;

    @JsonValue
    public List<Project> getProject() {
    if (project == null) {
        project = new ArrayList<Project>();
    }
    return this.project;
    }

}