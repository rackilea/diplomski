private String username;
    private String password;

public String login(){
       FacesContext context = FacesContext.getCurrentInstance();  
       HttpServletRequest request = (HttpServletRequest) context  
                                          .getExternalContext().getRequest();  

       try {  
            request.login(username, password);  
       } catch (ServletException e) {  
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login failed!", null));  
            return "login";  
       }  

       //database action to be done here  
       Principal principal = request.getUserPrincipal();    


       if(request.isUserInRole("admin")) {  
            return "/Pages/AdminLanding.xhtml";  
       } else {  
            return "/Pages/UserLanding.xhtml";  
       }  
  } //getter and setter for username and password