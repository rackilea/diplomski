public class UUIDArgument implements Argument {
    private final UUID value;

    public UUIDArgument(UUID value) {
        this.value = value;
    }

    @Override
    public void apply(int position, PreparedStatement statement, StatementContext ctx) throws SQLException {
        statement.setString(position, value.toString());
    }    
}