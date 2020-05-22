public class SuccesHandler implements AuthenticationSuccessHandler {
@Override
public void onAuthenticationSuccess(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) throws IOException, ServletException {
    Set<String> roles = AuthorityUtils.authorityListToSet(a.getAuthorities());
    int cont=0;

    String url = hsr.getRequestURL().toString();
    // String para ver si ya estamos adentro de la aplicacion o no
    String ams="http://192.168.1.32:8080/AMS1.1/";
    String referrer = hsr.getHeader("referer");
            //Vemos si tenemos el rol de USER y DCS 
     if(roles.contains("SETT_USER") && roles.contains("DCS_USER") )
    {
    // para el debugeo
    // System.out.print("holaaaaaaaaaaaaaaaaaaaaA:"+url);
    // System.out.print("holaaaaaaaaaasdfasdfaaaaaaaaaaaA:"+referrer);
     //Si estamos ya logueados   
     if(ams.equals(referrer))
     {
          hsr1.sendRedirect("/DCS?faces-redirect=true");// Si ya estamos logueados que nos redireccione a DCS
     }
     else
              hsr1.sendRedirect("/AMS1.1"); // Sino Que nos redireccione al homepage y de ahy al logging
    }
    else  if(roles.contains("DCS_USER") && roles.contains("SETT_USER"))
    {
         hsr1.sendRedirect("/DCS?faces-redirect=true");
    }

    System.out.print("MIS ROLEEEES"+roles.toString());
}