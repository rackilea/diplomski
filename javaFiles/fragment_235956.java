@ManagedBean  
@ViewScoped
public class YourBean implements Serializable{

String project_path;

public String getProject_path() {
    return project_path;
}

public void setProject_path(String project_path) {
    this.project_path = project_path;
}

@PostConstruct
public void init() {
    HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    project_path = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
}

public YourBean() {
}
}