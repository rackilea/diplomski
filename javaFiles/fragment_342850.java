@Path("/applications")
@Stateless
@LocalBean
public class ApplicationService {
    @EJB
    private ApplicationBean applicationBean;

    ... methods which use the applicationBean field ...
}