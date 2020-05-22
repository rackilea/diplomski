String viewId = "/path/to/some.xhtml";
FacesContext context = FacesContext.getCurrentInstance();
ViewDeclarationLanguage vdl = context.getApplication().getViewHandler().getViewDeclarationLanguage(context, viewId);

UIViewRoot view = vdl.createView(context, viewId);
vdl.buildView(context, view);
// view should now have children.