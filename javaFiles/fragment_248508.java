@Service
public class RESTServiceController {

    @GET
    @Produces("application/json") 
    public MyClass getResult() {
        return myClass;
    }
}