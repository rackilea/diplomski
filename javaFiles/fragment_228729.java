public interface TasksDAO {
    @SqlQuery("select task_id, title, description, creator_id, created_at from tasks")
    @Mapper(TaskMapper.class)
    Set<ImmutableTask> getAllTasks();

    @SqlQuery("select task_id, title, description, creator_id, created_at from tasks where task_id = :id")
    @Mapper(TaskMapper.class)
    ImmutableTask getTaskById(@Bind("id") int id);
}