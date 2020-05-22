public class DynamicAttributesTag extends SimpleTagSupport implements DynamicAttributes {
    ...
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        // This gets called every time a dynamic attribute is set
        // You could add the (localName,value) pair to your dynamicAttributes map here
    }
    ...
}