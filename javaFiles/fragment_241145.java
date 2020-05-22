public class TaskComparator implements Comparator<Task> {
    public int compare(Task left, Task right) {
        return left.getPriority() - right.getPriority();
        // Only because the numbers are limited. 
    }
}