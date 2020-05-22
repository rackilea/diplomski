@Controller
public class UserController {

    private static final String USER_HISTORY = UserController.class.getName() + "_USER_HISTORY";

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @ModelAttribute
    public User getUserModelAttribute() {
        return new User();
    }

    @GetMapping("/history")
    public String getHistoryView(HttpSession httpSession, Map<String, Object> model) {
        model.put("userHistory", getUserHistory(httpSession));
        return "index";
    }

    private List<User> getUserHistory(HttpSession httpSession) {
        // check if session exists
        Object history = httpSession.getAttribute(USER_HISTORY);
        if (history != null && history instanceof List) {
            return (List<User>) history;
        }
        return new ArrayList<>();
    }

    @PostMapping("/user")
    public String saveUser(HttpSession httpSession, @ModelAttribute User user) {
        List<User> history = getUserHistory(httpSession);
        history.add(user);
        httpSession.setAttribute(USER_HISTORY, history);
        return "redirect:/";
    }
}