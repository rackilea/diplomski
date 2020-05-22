@Override
public void sessionDestroyed(HttpSessionEvent se) {
    HttpSession session = se.getSession();
    User user = userService.findBySessionId(session.getId());    
    ApplicationScopedBean appBean = (ApplicationScopedBean) session.getServletContext().getAttribute("appBean");
    appBean.getConnectedUsers().remove(user);
}