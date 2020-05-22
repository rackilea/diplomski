@RequestMapping(value = "/")
public String index(Model model){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName(); // Get the username
// here you connect to your database and pull out the relevant entity object
Data data = dbDAO.findByUsername(username);
// now pull the person object and allocate it to a new object
Person person = data.getPerson();
// do your transformations or queries on the person object
// or
// pass it to your view layer via
model.addAttribute("person", person);
    model.addAttribute("username", username);
    return "index";
}