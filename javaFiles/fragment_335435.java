@MadvocAction(value = "login")
public class LoginAction extends BaseAction {

    Logger logger = LoggerFactory.getLogger(getClass());

    @PetiteInject
    UserService userService;

    @In(scope = ScopeType.SERVLET)
    protected HttpServletResponse servletResponse;

    @In(scope = ScopeType.SERVLET)
    protected HttpServletRequest servletRequest;

    @Action
    public void view() {
        if (logger.isInfoEnabled())
            logger.info("LoginAction.view()");
       // Code for getting ip Address
        forwardTo("/login.jsp");
    }
}