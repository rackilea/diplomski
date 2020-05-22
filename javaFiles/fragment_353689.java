FacesContext context = FacesContext.getCurrentInstance();
    String viewId = context.getViewRoot().getViewId();
    ViewHandler handler = context.getApplication().getViewHandler();
    UIViewRoot root = handler.createView(context, viewId);
    root.setViewId(viewId);
    context.setViewRoot(root);