@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public List<User> getAllUsers() {
        return UserDAO.getAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable int id) {
        return UserDAO.getById(id);
    }
}