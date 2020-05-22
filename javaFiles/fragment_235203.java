@Override
public void sessionDestroyed(HttpSessionEvent se) {
    HttpSession session = se.getSession();
    // do your processing
}
@Override
public void sessionCreated(HttpSessionEvent se) {
    // empty implementation if you do not need it ...
}