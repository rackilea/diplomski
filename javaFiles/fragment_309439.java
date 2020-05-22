public class SessionInitializer implements HttpSessionListener {
  public void sessionCreated(HttpSessionEvent event){
    HttpSession session = event.getSession();
    session.setAttribute("shoppingCart", new AtomicReference<ShoppingCart>());
  }
  public void sessionDestroyed(HttpSessionEvent event){
    // No special action needed
  }
}