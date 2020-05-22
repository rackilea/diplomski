public String save() {
    System.out.println("Saving changes to persistence store: id=" + id);
    redirect();
    return null; // no navigation
  }

  private void redirect() {
    FacesContext context = FacesContext.getCurrentInstance();
    ExternalContext ext = context.getExternalContext();
    UIViewRoot view = context.getViewRoot();
    String actionUrl = context.getApplication().getViewHandler().getActionURL(
        context, view.getViewId());
    try {
      // TODO encode id value
      actionUrl = ext.encodeActionURL(actionUrl + "?ID=" + id);
      ext.redirect(actionUrl);
    } catch (IOException e) {
      throw new FacesException(e);
    }
  }