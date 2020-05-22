@Controller
@RequestMapping("/user")
public final class UserController {

    private static final Logger LOG = LoggerFactory
                            .getLogger(UserController.class);

    @Autowired
    private transient UserService userService;

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public void downloadImage(
            @PathVariable("id") final Long id, 
            final HttpServletResponse response) throws IOException {
        // 
    }

}