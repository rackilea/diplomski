public class ForwardBean {
    private String action;
    private String actionParam;

    public void navigate(PhaseEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String outcome = action; // Do your thing?
        facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, outcome);
    }

    // Add/generate the usual boilerplate.
}