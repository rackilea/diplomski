public abstract class GenericRowMapper<T extends YourBaseEntityClass>
implements RowMapper<T> {

    public T mapRow(final ResultSet rs, final int rowNum)
    throws SQLException {
        final T entity = instantiateEntityClass();
        entity.setFooProperty(rs.getString("foo"));
        entity.setBarProperty(rs.getLong("bar"));
        return entity;
    }

    protected abstract T instantiateEntityClass();

}