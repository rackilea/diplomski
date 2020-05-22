@Service
public class MissionService { }

@Service
public class UserService {
    private MissionService missionService;

    @Autowired
    public void setMissionService(MissionService missionService) {
        this.missionService = missionService;
    }
}