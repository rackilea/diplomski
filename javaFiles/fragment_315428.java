@Controller
@RequestMapping("/users")
public class UserActionsController {
    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;    
    @Resource(name = "userActionsManager")
    private UserActionsManagerInterface userManager;
    @Resource(name = "databaseManager")
    private DB db;

    .
    .
    .

    @RequestMapping(value = "/{username}/{courseCode}/missions/{missionName}/tasks/{taskCode}/submitAnswer", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> giveAnswer(@PathVariable String username,
            @PathVariable String courseCode, @PathVariable String missionName,
            @PathVariable String taskCode, @RequestParam("answer") String answer, HttpServletRequest request) {
        init(request);
        db.log("Submitting an answer to task `"+taskCode+"` of mission `"+missionName+
               "` in course `"+courseCode+"` as student `"+username+"`.");
        String str = null;
        boolean conflict = true;

        for (int i=0; i<10; i++) {
            Random rand = new Random();
            int ms = rand.nextInt(1000);

            try {
                str = userManager.giveAnswer(username, courseCode, missionName, taskCode, answer);
                conflict = false;
                break;
            }
            catch (EntityExistsException e) {throw new EntityExistsException();}
            catch (PersistenceException e) {}
            catch (UnexpectedRollbackException e) {}

            try {
                Thread.sleep(ms);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        if (conflict) str = userManager.giveAnswer(username, courseCode, missionName, taskCode, answer);

        if (str == null) db.log("Answer accepted: `"+answer+"`.");
        else             db.log("Answer rejected: `"+answer+"`.");

        Map<String, Object> hm = new HashMap<String, Object>();

        hm.put("success", str == null);
        hm.put("message", str);

        return hm;
    }
}