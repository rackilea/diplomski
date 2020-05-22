@Controller
@RequestMapping("/sendmail")
public class MailController {
    @Autowired
    private MailService mailService;


    @RequestMapping(method = RequestMethod.POST)
    private String sendMail(HttpServletRequest request) {
         String covere = request.getParameter("covere");

        try {
            mailService.sendMail(covere);
            return "apply";
        } catch (MailException e) {
            e.printStackTrace();
        }
        return "apply";
    }
}