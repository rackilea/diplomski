public class AnotherServlet extends BaseForm {
    public AnotherServlet(STKUser user) {
        this.user = user;
        ...
    }

    public TD0301Assignment updateAssignment(HttpServletRequest request) {
        if (user.equals(tdas.getOriginator())) {
        ...