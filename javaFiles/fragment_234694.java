public class CheckUserCredentialsCommand implements Command {
public void execute(CommandContext commandContext) throws Exception {

    ILoginForm loginForm = new LoginForm();
    loginForm.populateFromForm(commandContext);

    List<ValidationMessage> messages = loginForm.validate();

    if(messages != null && messages.size() > 0){
        commandContext.setScopedVariable(PageConstants.LOGIN_MESSAGES, messages, ScopedContext.REQUEST);
    } else {        
        ControlPanelUser customer = ControlPanelUserDAO.selectControlPanelUser(loginForm.getEmailAddress(), loginForm.getPasswrd());
        if(customer != null){
            commandContext.setScopedVariable(PageConstants.CONTROL_PANEL_USER, customer, ScopedContext.SESSION);
        } else {
            commandContext.setScopedVariable(PageConstants.LOGIN_MESSAGES, messages, ScopedContext.REQUEST);
        }
    }
    String referer = commandContext.getRequest().getHeader("referer");
    if(referer != null){
        referer = referer.substring(referer.lastIndexOf("/") + 1, referer.length());
        if("login".equals(referer)){
            commandContext.redirect(commandContext.getServletContext().getContextPath()+"/administration/controlpanel/dashboard");
        } else {
            commandContext.redirect(commandContext.getRequest().getHeader("referer"));
        }
    } else {
        commandContext.redirect(commandContext.getServletContext().getContextPath()+"/administration/controlpanel/dashboard");
    }
}

}