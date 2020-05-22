@Controller
public class LoginPageController implements Initializable{

    @Autowired
    public LoginPageController(UserService userService, private StageManager stageManager){
        this.userService = userService;
        this.stageManager = stageManager;
    }
}