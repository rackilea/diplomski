import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.AbstractStandardBasicType;
import org.hibernate.type.descriptor.java.StringTypeDescriptor;
import org.hibernate.type.descriptor.sql.ClobTypeDescriptor;

public class TextType extends AbstractStandardBasicType<String> {

    public static final TextType INSTANCE = new TextType();

    public TextType() {
        super((myapp.isOracle?ClobTypeDescriptor.STREAM_BINDING:CustomSybaseTextTypeDescriptor.INSTANCE), StringTypeDescriptor.INSTANCE);
    }

    public String getName() {
        return "customtext";
    }

    @Override
    public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2,
            boolean[] arg3, SessionImplementor arg4)
            throws HibernateException, SQLException {
        if(arg1 == null)
            arg0.setNull(arg2,Types.VARCHAR);
        else
            super.nullSafeSet(arg0, arg1, arg2, arg4);
    }
}