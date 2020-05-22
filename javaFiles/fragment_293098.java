public class RolesAccess implements Serializable {

    public String getUserPrincipalName() {
        FacesContext context = FacesContext.getCurrentInstance();
        Principal principal = context.getExternalContext().getUserPrincipal();
        if(principal == null) {
            return null;
        }
        return principal.getName();
    }

    public String getUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().getRemoteUser();
    }

    public boolean isManager() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().isUserInRole("manager");
    }

}