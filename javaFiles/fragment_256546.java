public void validateParams() {
    if (yourParam == null || /*Other fitting conditions here*/) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().responseSendError(404, "The param 'yourParam' is missing");
        facesContext.responseComplete();
    }
    //Other params here
}