public class ParamGroupTag extends BodyTagSupport {

    public static final String NAME = "com.mycompany.taglib.ParamGroupTag";

    public int doStartTag() throws JspException {

        boolean exist = false;

        params = new HashMap();

        // your initialization code

        // Store this tag itself as a page attribute
        pageContext.setAttribute(ParamGroupTag.NAME, this);

        // Continue processing this page
        return (EVAL_BODY_BUFFERED);
    }

    /**
     * Adds the paramter this param object
     * @param paramName Parameter Name
     * @param value     Parameter Value
     */
    public void addParam(String paramName, Object value) {
        params.put(paramName, value);
    }

    /**
     * Clean up the Tag.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doEndTag() throws JspException {

        // tag functionality here

        // Remove the Tag from pageContext
        pageContext.removeAttribute(ParamGroupTag.NAME);

        // Continue processing this page
        return (EVAL_PAGE);
    }

}


public class ParamTag extends BodyTagSupport {

    /**
     * Reads the Params and Publishes to ParamGroup
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doStartTag() throws JspException {

        ParamGroupTag paramGroupTag = (ParamGroupTag)
                    pageContext.getAttribute(ParamGroupTag.NAME);

        if (paramGroupTag == null) {
            throw new JspException("ParamTag must be used with in ParamGroup Tag");
        }

        // read the attribtues

        paramGroupTag.addParam(id, value);

        // Continue processing this page
        return (EVAL_PAGE);
    }
}