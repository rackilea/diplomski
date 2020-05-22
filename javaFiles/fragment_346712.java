@Override
public void processEvent(SystemEvent e) {
  if(e instanceof PostConstructApplicationEvent) {
    try {
      // getting ejb by jndi
      InitialContext iCtx = new InitialContext();
      EjbService ejbService = (EjbService) iCtx.lookup("java:module/EjbService");

      // fetching resources
      ExternalContext eCtx = FacesContext.getCurrentInstance().getExternalContext();
      Set<String> resources = eCtx.getResourcePaths("/WEB-INF/");

      // setting resources into ejb
      ejbService.setResources(resources);
    } catch(NamingException e1) {
      e1.printStackTrace();
    }
  }
}