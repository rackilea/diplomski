protected Context createVelocityContext(Map <String, Object> model, 
                                        HttpServletRequest request,
                                        HttpServletRespsone response) 
                                        throws Exception {

    initVelocityContext();  //Still keep toolContext static
                            //will need to also add this to 
                            //the servletContext -- left as an exercise
    prepareToolboxes(request, response);
    Context context = 
        new ViewToolContext(getVelocityEngine(), request, 
                                response, getServletContext());
    //Set model attrs to context
    ....
    return context;
}

private void prepareToolboxes(final HttpServletRequest request, 
                              final HttpServletResponse response) {
    String key = Toolbox.class.getName();
    if (factory.hasTools(Scope.REQUEST && request.getAttribute(key) == null) {
        Toolbox requestTools = factory.createToolbox(Scope.REQUEST);
        request.setAttribute(key, requestTools);
    }
    if (factory.hasTools(Scope.SESSION) {
       HttpSession session = request.getSession();
       synchronized(factory) {
           //Follow pattern from above
       }
    }
}