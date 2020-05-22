public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    //Get a hold of the http request
    HttpServletRequest req = (HttpServletRequest)request; 

    //Access the HttpSession associated with the request
    HttpSession session =  req.getSession(false);  

    //Take what you want from the session
    activeUserModel = (ActiveUserModel) session.getAttribute("ActiveUserModel");         

    String username = SecurityAssociation.getPrincipal().getName();              

       if(activeUserModel.getUsername() == null) {
          try {
           pBean.consultaProfile(username);            

          } catch (SQLException e) {
            e.printStackTrace();
          } catch (NamingException e) {
            e.printStackTrace();
          } 
          }else{
        }        

      filterChain.doFilter(servletRequest, servletResponse);      
     }