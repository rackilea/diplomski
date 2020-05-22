@RestController
public class SimpleRestController {

    @Autowired
    SimpleService simpleService;

    @RequestMapping(value = "/user/public", method = RequestMethod.GET)
    @JsonView(User.Views.Public.class)
    public User getUserWithPublicData() {
        return simpleService.loadUser();
    }


    @RequestMapping(value = "/user/internal", method = RequestMethod.GET)
    @JsonView(User.Views.Internal.class)
    public User getUserWithInternalData() {
        return simpleService.loadUser();
    }
}