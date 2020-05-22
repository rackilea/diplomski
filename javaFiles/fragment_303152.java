public class MyBean {
    private Priority priority;

    // Never returns null :)
    public Priority getPriority() {
        return (priority != null) ? priority : Priority.DEFAULT;
    }
}