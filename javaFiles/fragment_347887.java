@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(MyPojoBean.class, new MyPojoEditor());
}

class MyPojoEditor extends java.beans.PropertyEditorSupport {
    @Override public String getAsText () {...}
    @Override public void setAsText (String s) {...}
}