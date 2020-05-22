@RestController
public class UserRestService {

  @RequestMapping("/user")
  public Principal user(Principal user) {
    // you can also return User object with it's roles
    // {"details":...,"principal":{"username":"user",...},"name":"user"}
    return user;
  }

}