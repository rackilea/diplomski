@GuiceManaged(module = HelloModule.class, 
    address = "http://localhost:8080/helloService")
@WebService
public class HelloServiceImpl implements HelloService {

    @Inject // bound in HelloModule
    public GreetingsService greetingsService;

    @Override
    @WebMethod
    public String sayHello(final String name) {
        return greetingsService.sayHello(name);
    }
}