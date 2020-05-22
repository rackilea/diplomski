@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping
    public List<User> findAllByRsql(@RequestParam(value = "search") String search) {
        Node rootNode = new RSQLParser().parse(search);
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
        return repo.findAll(spec);
    }

}