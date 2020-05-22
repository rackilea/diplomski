private UIComponent component;

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }


           public String login(){

        try{
           ad=  adminEJB.verifyUser(                                  
           username,password);
           If(ad!=null)
              return="welcome";
           else {               
          FacesContext context = FacesContext.
               getCurrentInstance();
          context.addMessage(component.getClientId(),
              new FacesMessage("Login Failed")); 
          return "login";
         }

        }catch(EJBException e){
          FacesContext context = FacesContext.getCurrentInstance();
          context.addMessage(component.getClientId(),
            new FacesMessage(e.getMessage()));                                                                       return "login";
         }
      }