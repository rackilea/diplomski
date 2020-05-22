@Controller
public class TaskController {
    @Autowired
    UserService userService;

    //...
    @RequestMapping(value = "/docreatetask", method = RequestMethod.POST)
    public String doCreateTask(Model model, @Valid Task task,
            BindingResult result, Principal principal,
            @RequestParam(value = "delete", required = false) String delete) {
        //current code...
        task.setIdUser(userService.get(username).getIdUser());
        //rest of your code...
    }
}