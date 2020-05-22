@Path("/resource")
@Component
public class MyResource {

    @Autowired
    private MyService myService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return myService.sayHello();
    }
}