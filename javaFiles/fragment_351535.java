public class SetHandler<T> implements ResultSetHandler<Set<T>> {
    private final RowProcessor rp = new BasicRowProcessor();
    private final Class<T> type;

    public SetHandler(Class<T> type) {
        this.type = type;
    }

    @Override
    public Set<T> handle(ResultSet rs) throws SQLException {
        Set<T> set = new HashSet<>();
        while (rs.next()) {
            set.add((T) this.rp.toBean(rs,type));
        }
        return set;
    }
}