@Controller
@RequestMapping(LoginController.ROOT_MAPPING)
public class LoginController {

  @RequestMapping("/login**")
  public String login(HttpServletRequest request, Model model) {
     // model.addAttribute("requestedResource", requestedResource);

  SavedRequest savedRequest = 
    new HttpSessionRequestCache().getRequest(request, response);
  String url = savedRequest.getRedirectUrl();
  // do what you want with url variable and OAuth...

  return "login";
  }
}