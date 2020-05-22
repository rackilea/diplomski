public abstract class AbstractController {
    @PostConstruct
    protected void postConstruct() {
        System.out.println("post construct");
    }
}

@Controller
public class ConcreteController extends AbstractController {

}