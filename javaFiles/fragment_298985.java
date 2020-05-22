package com.mycompany.usertype;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.descriptor.java.FloatTypeDescriptor;
import org.hibernate.usertype.UserType;

public class CoordenadaUserType implements UserType {

    public static final CoordenadaUserType INSTANCE = new CoordenadaUserType();

    @Override
    public int[] sqlTypes() {
        return new int[] {Types.REAL};
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class returnedClass() {
        return Float.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
            throws HibernateException, SQLException {
        String columnName = names[0];
        Float columnValue = (Float) rs.getObject(columnName);
        return columnValue == null ? null : columnValue;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
            throws HibernateException, SQLException {
        if(value == null){
            st.setNull( index, Types.REAL );
        }else{
            String stringValue = FloatTypeDescriptor.INSTANCE.toString((Float)value);
            st.setString(index, stringValue);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

}