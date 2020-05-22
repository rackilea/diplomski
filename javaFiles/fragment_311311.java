@Controller
public class HomeController {

    @Autowired
    @Qualifier("Subscriber")
    private SubscriberService subService;

}