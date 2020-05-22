private void cleanUserSession(HttpServletRequest _request) {
    HttpSession session = (HttpSession) _request.getSession(false);
    if ( session != null ){
        session.setAttribute(ClientUtil.AUTH_TOKEN, "" );
        session.setAttribute(ClientUtil.USUER_INFO, null);
    }
}