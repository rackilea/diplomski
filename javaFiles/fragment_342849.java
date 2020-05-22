@Stateless
@LocalBean
public class ApplicationBean {
    @EJB
    private ApplicationDao applicationDao;

    ... some methods ...
}