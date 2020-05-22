@Controller
public class SomeController {
@Autowired
            SomeFacadeService someFacadeService ;

    @RequestMapping("/someMapping")
    public void doSomeJob() {
        someFacadeService.doComplexJob();
    }
}

@Service
        public class SomeFacadeService {
            @Autowired
            ProfileService profileService;
            @Autowired
            OuterService outerService;

            @Transactional
            public void doComplexJob() {
                profileService.createProfile();
                outerService.doOuterJob();
            }
        }

        @Service 
        public class ProfileService {
            @Transactional
            public void createProfile() {
                // create profile logic
            }
        }