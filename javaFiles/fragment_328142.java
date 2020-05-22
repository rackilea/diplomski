String viewId = "/path/to/some.xhtml";
FacesContext context = FacesContext.getCurrentInstance();
ViewHandler viewHandler = context.getApplication().getViewHandler();

UIViewRoot view = viewHandler.createView(context, viewId);
viewHandler.getViewDeclarationLanguage(context, viewId).buildView(context, view);
// view should now have children.