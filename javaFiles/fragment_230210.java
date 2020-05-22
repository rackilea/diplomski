@Controller
public class UserAccountController {

    private UserRepository userRepository;

    private TokenRepository tokenRepository;

    private EmailSenderService emailSenderService;

    @Autowired
    public UserAccountController(UserRepository userRepository, TokenRepository tokenRepository, EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.emailSenderService = emailSenderService;
    }