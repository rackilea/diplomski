@Controller
@Slf4j
public class HomeController {

    private final List<Customer> customers = new ArrayList<>(3);
    private final Map<String, List<Project>> map = new ConcurrentHashMap<>(3);

    public HomeController() {
        // initialize the list and map
        for (int i = 0; i < 3; i++) {
            final Customer c = new Customer("customer-" + i);
            customers.add(c);
            final List<Project> projects = new ArrayList<>(3);
            for (int j = 0; j < 3; j++) {
                final Project p = new Project("project-" + i + "" + j);
                projects.add(p);
            }
            map.put(c.getName(), projects);
        }

    }

    @GetMapping("/")
    public String index(Model model) {
        log.info("customers : {}", customers);
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/{name}")
    public @ResponseBody List<Project> index(@PathVariable("name") String name) {
        final List<Project> projects = map.get(name);
        log.info("projects : {}", projects);
        return projects;
    }
}