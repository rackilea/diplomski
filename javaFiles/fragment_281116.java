@Stateless
public class FooManager {

    @Inject
    private FooDAO fooDAO;


    public List<FooEntity> getFoos() {
        return fooDAO.findAll();
    }

    // ...
}