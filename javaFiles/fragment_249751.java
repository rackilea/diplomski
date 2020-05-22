@FacesComponent("com.example.LoginForm")
public class LoginFormComponent extends UIInput implements NamingContainer
{
    @Override
    protected Object getConvertedValue(FacesContext context, Object newSubmittedValue) throws ConverterException
    {
        UIInput emailAddressComponent = (UIInput) findComponent(EMAIL_ADDRESS_ID);
        UIInput passwordComponent = (UIInput) findComponent(PASSWORD_ID);
        String emailAddress = (String) emailAddressComponent.getValue();
        String password = (String) passwordComponent.getValue();
        return new LoginFormValue(emailAddress, password);
    }

    public void postValidate(ComponentSystemEvent e) {
        FacesContext ctx = getFacesContext();

        // Don't validate credentials if the username and/or password fields are invalid.
        if (!ctx.getMessageList(EMAIL_ADDRESS_ID).isEmpty() || !ctx.getMessageList(PASSWORD_ID).isEmpty())
        {
            return;
        }

        LoginFormValue value = (LoginFormValue) getConvertedValue(null, null);
        MethodExpression checkCredentials = (MethodExpression) getAttributes().get(CHECK_CREDENTIALS_ATTRIBUTE_NAME);
        checkCredentials.invoke(ctx.getELContext(), new Object[]{getClientId(), value.getEmailAddress(), value.getPassword()});
    }

    @Override
    public String getFamily()
    {
        return "javax.faces.NamingContainer";
    }

    public static final String CHECK_CREDENTIALS_ATTRIBUTE_NAME = "checkCredentials";
    public static final String EMAIL_ADDRESS_ID = "form:emailAddress";
    public static final String PASSWORD_ID = "form:password";
}