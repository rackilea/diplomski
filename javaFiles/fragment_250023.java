String sql = "DELETE FROM persons WHERE name = ? AND email = ? AND age = ?";
int[] argTypes = { Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

List<Object[]> batchArgs = new ArrayList<>();
batchArgs.add(new Object[] { "John Doe", "john@example.com", 42 });
batchArgs.add(new Object[] { "Jane Smith", "jane@example.com", 47 });
. . .

JdbcTemplate template = ...;
int[] rowCounts = template.batchUpdate(sql, batchArgs, argTypes);