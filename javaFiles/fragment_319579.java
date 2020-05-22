public class MyJspFactory extends JspFactory {
    private static JspFactory _myFactory = null;
    public MyJspFactory(JspFactory factory) {
        _myFactory = factory;
    } 
   //All abstract methods which looks up _myFactory and does the same thing

   public PageContext getPageContext(Servlet servlet, ServletRequest request, ServletResponse response, String errorPageURL, boolean needsSession, int bufferSize, boolean autoflush) {
        PageContext myCtxt = _myFactory.getPageContext(....)
        //Create a customPageContext and wrap myCtxt in it and return
   }
}