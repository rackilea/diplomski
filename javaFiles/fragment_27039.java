@ResponseBody
@RequestMapping(method = RequestMethod.GET)
public Object getUsers(Pageable pageable) {

    Page<User> users = userReposiotry.findAll(pageable);
    Resources<User> userResources  = new Resources<>(users);

    List<MyCustomUser> customUsers = [...]

    return customUSers;
}

// "some more specific details" in MyCustomUser
public class MyCustomUser extends User{

    private List<Links> links;

    // TODO: constructor, getter, setter.
}