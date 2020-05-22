public class StateUserType implements UserType {   

    private static final int[] SQL_TYPES = {Types.VARCHAR}; 

    public int[] sqlTypes() {   
        return SQL_TYPES;   
    }   

    public Class returnedClass() {   
        return State.class;   
    }   

    public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner) throws HibernateException, SQLException {   
        String stateName = resultSet.getString(names[0]);   
        State result = null;   
        if (!resultSet.wasNull()) {   
            result = State.forStateName(stateName);
        }   
        return result;   
    }   

    public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index) throws HibernateException, SQLException {   
        if (null == value) {   
            preparedStatement.setNull(index, Types.VARCHAR);   
        } else {   
            preparedStatement.setString(index, ((State)value).stateName());   
        }   
    }   

    public Object deepCopy(Object value) throws HibernateException{   
        return value;   
    }   

    public boolean isMutable() {   
        return false;   
    }   

    public Object assemble(Serializable cached, Object owner) throws HibernateException    
         return cached;  
    }   

    public Serializable disassemble(Object value) throws HibernateException {   
        return (Serializable)value;   
    }   

    public Object replace(Object original, Object target, Object owner) throws HibernateException {   
        return original;   
    }   

    public int hashCode(Object x) throws HibernateException {   
        return x.hashCode();   
    }   

    public boolean equals(Object x, Object y) throws HibernateException {   
        if (x == y) {
            return true;
        }   
        if (null == x || null == y) {   
            return false;
        }
        return x.equals(y);   
    }   
}