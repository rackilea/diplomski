public String doSubmitAction() {
  if(category == null) {
    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No node selected", "No node selected");
    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    return null;
  }
  // do other stuff
}