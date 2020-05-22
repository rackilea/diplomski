@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("user")
    public List<Exercice> populateUser() {
        User user = /* Get your user from service or security context or elsewhere */;
        return user;
    }
}