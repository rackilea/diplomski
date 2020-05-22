package my;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;


public class PGNillableIntegerType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.OTHER };
    }

    @Override
    public Class returnedClass() {
        return NillableInteger.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names,
            SessionImplementor session, Object owner)
            throws HibernateException, SQLException {

        return new NillableInteger(rs.getString(names[0]));
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,
            SessionImplementor session) throws HibernateException, SQLException {
        if(value == null) {
            st.setObject(index, null, Types.OTHER);
        } else {
            final NillableInteger nillable = (NillableInteger)value;
            st.setObject(index, nillable.toString(), Types.OTHER);
//          IntegerType.INSTANCE.set(st, nillable.getValue(), index, session);
//          StringType.INSTANCE.set(st, nillable.getNill(), index + 1, session);
        }
    }

    @Override
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }

    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
    }

    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    public boolean equals(Object arg0, Object arg1) throws HibernateException {
        return arg0.equals(arg1);
    }

    public int hashCode(Object object) throws HibernateException {
        return object.hashCode();
    }

    public boolean isMutable() {
        return false;
    }



}