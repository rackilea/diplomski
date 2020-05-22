@EnableScheduling
@Component
public class SpringCronJob {

private static Logger log = Logger.getLogger(SpringCronJob.class.getName());

@Autowired
TargetDAO targetDAO;

@Scheduled(fixedRate = 15000)
public void getPostedTargets() {
      try {
          log.info(targetDAO.getAllTargets());
      } catch (Exception e) {
            // TODO Auto-generated catch block
          e.printStackTrace();
      }
  }
}