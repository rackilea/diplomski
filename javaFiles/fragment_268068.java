@Autowired
UserService usrv;

//private UserService usrv = new UserService();

@RequestMapping(value = "/verusuarios", method = RequestMethod.GET)
public String listPersons(Model model) {
    List<Users> list = usrv.getAllUsers();
    model.addAttribute("user", new Users());
    model.addAttribute("list", list);
    return "verusuarios";
}