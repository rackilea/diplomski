@Controller
class MyController {

    @RequestMapping
    public void handleMe(HttpServletRequest request) {
        String path = request.getContextPath();
    }
}