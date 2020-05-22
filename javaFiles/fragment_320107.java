@Service
public class EmailAsyncService {
    ...
    @Autowired
    private MailService mailService;

    @Async
    public void sendEmail(User user, String email) {
        if (!user.getEmail().equals(email)) {
            user.setEmailTemp(email);
            Map map = new HashMap();
            map.put("name", user.getName() + " " + user.getSurname());
            map.put("url", "http://activationLink");
            mailService.sendMail(map, "email-activation");
        }
    }
}