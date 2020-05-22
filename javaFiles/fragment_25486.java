public class CourierTransImpl implements IdentifierGenerator, Configurable {

private String appendString;

@Override
public Serializable generate(SessionImplementor session, Object object)
        throws HibernateException {
    Connection connection = session.connection();
    int id = 0;
    try {
        Employee emp = (Employee) object;
        id = ..; // your logic to get the id from database

        // Now you can use the parameter appendString which is static value set to "Emp"
       // You can also access any of the employee properties here, so in your code you can set the required value dynamically.
        return appendString + emp.getEmpType()+id;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return appendString + id;
}

@Override
public void configure(Type type, Properties params, Dialect d)
        throws MappingException {
    setAppendString(params.getProperty("appendString")); // Here we are setting the parameters.
}

// Setters & Getters