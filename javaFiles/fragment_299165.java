public class HomeAction implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
         //perform your home related action here..
         return "home";
    }
}