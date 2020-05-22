@Singleton
public class TaskDao {

    private static ThreadLocal<Set<ActiveTasks>> tasksThreadLocal = new ThreadLocal<>(){
        @Override
        protected Set<ActiveTasks> initialValue() {
            return new HashSet<>();
        }
    };

    filterActiveTasks() {
         Set<ActiveTasks> tasks = tasksThreadLocal.get();
         //work with the Set
    }
}