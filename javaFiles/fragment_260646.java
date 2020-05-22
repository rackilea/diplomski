@WebMethod
public void foo() {
    final MessageContext mc = this.wsContext.getMessageContext();
    final ServletRequest sr = mc.get(MessageContext.SERVLET_REQUEST);

    /* works if this is a HTTP(s) request */
    if (sr != null && sr instanceof HttpServletRequest) {
        final HttpServletRequest hsr = (HttpServletRequest) sr;
        hsr.getSession(true);

        /* ... */

    } else {
        /* do some exceptional stuff */
    }

}