@GetMapping(value = "/users")
public List<User> getUsers() {

   List<User> users = userRepository.findAll(); // users was loaded
   return users; // addresses was loaded for each user one by one
}