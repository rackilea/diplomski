public class MenuTagHandler extends TagSupport {

    private String id;
    private String cssClass;
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public int doStartTag() throws JspException {
        logger.info("tagSupport doStartTag method entered");

        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        HttpSession session = request.getSession();

        Menu menu = (Menu)session.getAttribute("app.menu");

        // do whatever you need to do with the menu data

        return SKIP_BODY;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
}