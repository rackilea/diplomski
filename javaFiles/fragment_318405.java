@Controller
@RequestMapping({ "/user/limits" })
    public class UserController {

        private String wsgServiceURL;

        @Autowired
        public void initProperty(@Value("${wsgServiceURL}") String wsgServiceURL) {
            if(wsgServiceURL== null) {
                // Error handling here
            }
        }
    }