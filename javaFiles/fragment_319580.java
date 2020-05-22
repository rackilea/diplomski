public class MyPageContext extends PageContext {
    private PageContext _ctxt = null;

    public void setPageContext(PageContext ctxt) {
        _ctxt = ctxt;
    }

    //Implement all abstract methods using _ctxt object

    @override
    public  JspWriter getOut() {
        JspWriter _out = _ctxt.getOut();

        //Wrap _out object using MyJSPWriter as mentioned in question and return back;

    }
}