public class UserSessionController extends SessionController{
@Inject
private AdminFacade adminFacade;

@RequestMapping("/welcome/{a}")
public String getActiveSessions(@PathVariable String a) {
    return adminFacade.getName(a);
}
}

@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminFacade {

public String getName(String name) {
    return "This is "+name;
}
public String getDetailsForAdmin(String param) {
    return "admin details";
}
}