public class TaskScheduler <T extends TaskService>{

    private T taskService;

    public void setTaskService(T taskService) {
        this.taskService = taskService;
    }
}