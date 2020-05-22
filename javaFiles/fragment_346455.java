@Entity
public class Project {
    ...
    public void addToApplications(Application app) {
        this.applications.add(app);
        app.setProject(this);
    }
    ...
}