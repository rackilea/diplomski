public ActionForward login( ... ) throws Exception {
    String forward;
    final String mail = PropertyUtils.getProperty(form, "mail");
    final String password = PropertyUtils.getProperty(form, "password");
    if (LoginService.getInstance().validate(mail, password)) {
        // Do something e.g. put name of user in session
        forward = SUCCESS;
    } else {
        forward = ERROR;
    }
    return mapping.findForward(forward);
}