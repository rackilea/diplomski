@Component public class ContextInitializer {

@Autowired
private JavaMailSender mailSender;

@PostConstruct
public void postConstruct() {
    EmailUtility.setMailSender(mailSender);
}