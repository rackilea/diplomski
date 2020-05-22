public class CalendarType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] {Types.BIGINT};
    }

    @Override
    public Class<?> returnedClass() {
        return Calendar.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names,SessionImplementor session, Object owner) throws HibernateException, SQLException {
        Long timeInMillis = resultSet.getLong(names[0]);
        if (timeInMillis == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timeInMillis);
            return calendar;
        }       
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        Calendar calendar = (Calendar) value;
        preparedStatement.setLong(index, calendar.getTimeInMillis());       
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        Calendar calendar = (Calendar) value;       
        return calendar.getTimeInMillis();
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        Long timeInMillis = (Long) cached;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return calendar;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}