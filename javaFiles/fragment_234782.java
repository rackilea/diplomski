@Component
public class AnotherBean{

    @Inject 
    private DatabaseQueries queries;

    public void doSomething {
        List<Records> data = queries.getData();
    }
}