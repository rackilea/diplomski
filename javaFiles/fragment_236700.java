@Override
public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
    Connection connection = session.connection();
    CallableStatement callable = null;
    try {
        callable = connection.prepareCall("execute [procedure] ?");
        callable.registerOutParameter(1, Types.INTEGER);
        callable.execute();
        int id = callable.getInt(1);

        return id;
    } catch (SQLException e) {
        (...)
    } finally {
        (...)
    }
}