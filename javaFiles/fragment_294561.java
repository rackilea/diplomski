@Component
@Scope(value = "session")
public class TaskManagedBean implements Serializable {

private static final long serialVersionUID = 1L;
private static final String SUCCESS = "success";
private static final String ERROR   = "error";

//NOTE: Task Service is injected
@Autowired
TaskService taskService;