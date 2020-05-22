protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionKey = request.getParameter("action");
        Action action = actionMap.get(actionKey);
        String view = action.execute(request, response);

        //Here, if view is if failure then, forward to jsp, to available request attributes in jsp. 
        //      if view is success redirect to jsp..

}