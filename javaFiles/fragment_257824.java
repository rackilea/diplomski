@Override
public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException
{
    if (value == null)
        st.setString(index, "ROLE");
    else
        st.setString(index, s);
}