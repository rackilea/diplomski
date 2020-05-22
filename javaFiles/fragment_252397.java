import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class AtomicIntegerType implements UserType {

    private static final Logger logger = Logger.getLogger("AtomicInteger");

    /**
     * Returns the object from the 2 level cache
     */
    @Override
    public Object assemble(final Serializable cached, final Object owner)
            throws HibernateException {
        //would work as the AtomicInteger.class is Serializable, 
        //and stored in cache as it is - see disassemble
        return cached;
    }

    /**
     * Used to create Snapshots of the object
     */
    @Override
    public Object deepCopy(Object value) throws HibernateException {
        //return value; -> if AtomicInteger.class was immutable we could return the object as it is
        final AtomicInteger recievedParam = (AtomicInteger) value;
        final AtomicInteger atomicInteger = new AtomicInteger(recievedParam.get());
        return atomicInteger;
    }

    /**
     * method called when Hibernate puts the data in a second level cache. The
     * data is stored in a serializable form
     */
    @Override
    public Serializable disassemble(final Object value) throws HibernateException {
        //For this purpose the AtomicInteger.class must implement serializable
        return (Serializable) value;
    }

    /**
     * Used while dirty checking - control passed on to the
     * {@link AtomicInteger}
     */
    @Override
    public boolean equals(final Object o1, final Object o2) throws HibernateException {
        boolean isEqual = false;
        if (o1 == o2) {
            isEqual = true;
        }
        if (null == o1 || null == o2) {
            isEqual = false;
        } else {
            isEqual = o1.equals(o2);
        }
        return isEqual;
        //for this to work correctly the equals() 
        //method must be implemented correctly by AtomicInteger class
    }

    @Override
    public int hashCode(final Object value) throws HibernateException {
        return value.hashCode();
        //for this to work correctly the hashCode() 
        //method must be implemented correctly by AtomicInteger class

    }

    /**
     * Helps hibernate apply certain optimizations for immutable objects
     */
    @Override
    public boolean isMutable() {
        return true; //The audit fields can be modified
    }

    /**
     * This method retrieves the property value from the JDBC resultSet
     */
    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, SharedSessionContractImplementor ssci, Object owner) throws HibernateException, SQLException {
        //owner here is class from where the call to retrieve data was made.
        //In this case the Test class
        AtomicInteger atomicInteger = null;
        if (!resultSet.wasNull()) {
            atomicInteger = new AtomicInteger(resultSet.getInt(names[0]));            
        }
        return atomicInteger;
    }

    /**
     * The method writes the property value to the JDBC prepared Statement
     *
     */
    @Override
    public void nullSafeSet(final PreparedStatement statement,
            final Object value, final int index, SharedSessionContractImplementor ssci) throws HibernateException,
            SQLException {
        if (null == value) {
            statement.setNull(index, java.sql.Types.INTEGER);
        } else {
            AtomicInteger atomicInteger = (AtomicInteger) value;
            if (null != atomicInteger) {
                statement.setInt(index , atomicInteger.get());
            } else {
                statement.setNull(index, java.sql.Types.INTEGER);
            }

        }
    }

    /**
     * Method used by Hibernate to handle merging of detached object.
     */
    @Override
    public Object replace(final Object original, final Object target,
            final Object owner)
            throws HibernateException {
        //return original; // if immutable use this
        //For mutable types at bare minimum return a deep copy of first argument
        return this.deepCopy(original);

    }

    /**
     * Method tells Hibernate which Java class is mapped to this Hibernate Type
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Class returnedClass() {
        return AtomicInteger.class;
    }

    /**
     * Method tells Hibernate what SQL columns to use for DDL schema generation.
     * using the Hibernate Types leaves Hibernate free to choose actual SQl
     * types based on database dialect. (Alternatively SQL types can also be
     * used directly)
     */
    @Override
    public int[] sqlTypes() {
        //createdBy, createdDate,modifiedBy,modifiedDate
        return new int[]{java.sql.Types.INTEGER};
    }

}