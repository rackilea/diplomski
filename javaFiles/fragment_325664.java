public String authenticate()
{
    String result = null;
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    try
    {
        request.login(userId, password);
        result = "/private/MainPage.xhtml?faces-redirect=true";
    }
    catch (ServletException ex)
    {
        logger.error("Failed to authenticate user.", ex);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, Messages.getString("Login.InvalidIdOrPasswordMessage"), null);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    return result;
}