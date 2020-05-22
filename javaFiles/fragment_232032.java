public class Task extends Thread {
    private Entity entity;
    public Task(Entity entity) {
        this.entity = entity;
    }
    public void run() {
        entity.setStatus(Status.RUNNING);
        // ...
        // Long running task here.
        // ...
        entity.setStatus(Status.FINISHED);
    }
}