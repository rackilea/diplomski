@BasePathAwareController
@RequestMapping("/users")
public class RestApiController implements ResourceProcessor<Resource<User>>{
    @Autowired
    private EntityLinks entityLinks;

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Resource<User>> saveUser(@Param("name") String name) {
        // Testing
        System.out.println(name);
        Resource<User> resource = new Resource<>(new User());
        return new ResponseEntity<>(resource , HttpStatus.OK);
    }

    @Override
    public Resource<User> process(Resource<User> resource) {
            LinkBuilder lb = entityLinks.linkFor(User.class);
            resource.add(new Link(lb.toString()));
        return resource;
    }
}