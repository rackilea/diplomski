public boolean preHandle(HttpServletRequest request,
                HttpServletResponse response, Object handler) throws Exception {
                ...
                HttpSession session = request.getSession();
                session.setAttribute("attributeName", objectYouWantToPassToHandler);
                ....
                }
    In your handler handleRequest method:

       public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {                

            ....
            HttpSession session = request.getSession();
            objectYouWantToPassToHandler objectYouWantToPassToHandler = session.getAttribute("attributeName");
            ....


  }