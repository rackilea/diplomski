public class TaskMapper implements ResultSetMapper<ImmutableTask> {
    public ImmutableTask map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return ImmutableTask.builder()
                .taskId(r.getInt("task_id"))
                .creatorId(r.getInt("creator_id"))
                .title(r.getString("title"))
                .description(r.getString("description"))
                .createdAt(r.getTimestamp("created_at"))
                .build();
    }
}