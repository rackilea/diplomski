@KeepAlive(ajaxOnly=false)
public class PageXBean {
    //some attributes...
    public PageXBean() {
        ClassX oClassX = new ClassX();
        //set data into oClassX ...
        try {
            FacesContext objFC = FacesContext.getCurrentInstance();
            Object request = objFC.getExternalContext().getRequest();
            HttpServletRequest objServletRequest = (HttpServletRequest)request;
            HttpSession objSesion = objServletRequest.getSession();
            objSesion.setAttribute(UConstants.SessionVars.CLASS_X, oClassX);
        } catch (Exception objEx) {
            System.out.println("Problema al registrar variable de sesión: " +
                objEx.getMessage());
      }
    }
    //more methods and stuff...
}