package com.mytags;
public class SomeTag extends SimpleTagSupport {

    private SomeBean bean;

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write(bean.doSomething());
    }

    public SomeBean getBean(){...}
    public void setBean(SomeBean bean){...}
}