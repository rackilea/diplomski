@Component
public class Service {

    @Autowired 
    private iHelper helper;

    public void doSomething() {
        helper.helpMeOut();
    }
}