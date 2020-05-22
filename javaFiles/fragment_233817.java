@Service
public class MailService {
    public void sendEmail(String email) {
        String templatePath = "/verifyEmail.vm";
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("email", email);

        // mailSender is always null
        String mailBody = mailSender.getMailContent(templatePath, model);
    }

    // Autowired here is not working
    @Autowired
    private MailSender mailSender;
}