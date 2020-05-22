@javax.ejb.Local
public interface LocalBusinessInterface {
}

@javax.ejb.Remote
public interface RemoteBusinessInterface {
}

//@LocalBean is annotation that was introduced in EJB 3.1
//according Javadoc it "Designates that a session bean exposes a 
//no-interface view."
//When bean does not implement other interfaces, using @LocalBean
//is redundant, because beans without any interfaces expose no-interface view
//by default.
@LocalBean
@Stateless
public class BeanImplementation 
    implements LocalBusinessInterface, RemoteBusinessInterface {
}