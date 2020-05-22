@Controller
public class ServiceController implements ApplicationListener<ContextRefreshedEvent> {

    private static final Map<String, String> cache = new HashMap<>();

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping("/getAllCountry")
    public String getAllCountry() {
        return userService.getAllCountry();
    }

    @RequestMapping("/getAllStates")
    public String getAllStates() {
        return userService.getStates();
    }

    public void cacheData() {
        cache.put("ALL_COUNTRY_DATA", getAllCountry());
        cache.put("ALL_STATE_DATA", getAllStates());
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        cacheData();
    }
}