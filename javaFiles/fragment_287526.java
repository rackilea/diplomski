@Local
public interface ServiceLocal {
}

@Remote
public interface ServiceRemote {
}

@Stateless
public class ServiceEJB implements ServiceLocal, ServiceRemote {
}