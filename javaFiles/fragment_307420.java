public int doStartTag() throws JspException {
    try {
        pageContext.setAttribute("title", "My Title");
        pageContext.getRequest().getRequestDispatcher("/WEB-INF/includes/header.jspf").include(pageContext.getRequest(), pageContext.getResponse());
    }
    catch (IOException e) {

    }
    return EVAL_BODY_INCLUDE;
}