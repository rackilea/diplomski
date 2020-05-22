public class TaskObject {
    private String name;
    private boolean active = false;

    public TaskObject(final String name) {
        this.name = name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void start() {
        this.active = true;
    }

    public void stop() {
        this.active = false;
    }

    public boolean isActive() {
        return this.active;
    }
}