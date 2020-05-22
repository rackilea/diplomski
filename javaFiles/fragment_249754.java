@Named
@RequestScoped
public class LoginBean implements Serializable
{
    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public boolean isRememberMe()
    {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe)
    {
        this.rememberMe = rememberMe;
    }

    /** Action listener for login-form. Called after validation passes. */
    public void submit()
    {
        User user = userDao.findByEmailAddress(emailAddress);
        userRequestBean.login(user.getUserId());

        // Remember me
        if (!rememberMe)
        {
            return;
        }

        // Handle rememberMe here (create a cookie, etc.)
    }

    /** Called by the backing component's postValidate event handler */
    public void checkCredentials(String clientId, String emailAddress, String password)
    {
        if (!securityEjb.checkCredentials(emailAddress, password))
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect email address/password", null);
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(clientId, message);
            ctx.renderResponse();
        }
    }

    private String emailAddress = "";

    private boolean rememberMe = true;

    @Inject
    private UserRequestBean userRequestBean;

    @EJB
    private SecurityEjb securityEjb;

    @EJB
    private UserDao userDao;

    @EJB
    private LoginCookieDao loginCookieDao;
}