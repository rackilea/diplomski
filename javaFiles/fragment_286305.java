@GetMapping(value = "/users")
public List<User> getUsers() {

   List<User> users = userRepository.findAll(); // users and addresses was loaded
   return users;
}