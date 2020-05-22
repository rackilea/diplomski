public class MyComponent implements Callable, MuleContextAware {

MuleContext context;

@Override
public Object onCall(MuleEventContext eventContext) throws Exception {

    ExpressionLanguage el = context.getExpressionLanguage();
    String result = el.evaluate("mule.home");
    return result;
}

@Override
public void setMuleContext(MuleContext context) {
    this.context = context;
}
// include getters and setters for context