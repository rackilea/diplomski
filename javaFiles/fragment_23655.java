@Component("projectView")
@ViewScoped
@ManagedBean("projectView")
public class ProjectView {
    @ManagedProperty("#{treeBean.selectedProject}")
    private Project project; 
    public ProjectView(){}
}