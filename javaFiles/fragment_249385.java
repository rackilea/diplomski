public class TaskList {

    private SystemUser owner;
    private List<Task> tasks = new ArrayList<>();

    public TastList(SystemUser owner) {
        this.owner = owner;
    }

    public void Add(Task task) {
        Guard.allowFor(owner); 
        tasks.add(task);
    }
}