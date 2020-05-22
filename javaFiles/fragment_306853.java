public class MyCustomWebSecurityExpressionHandler
              extends DefaultWebSecurityExpressionHandler {

      @Override        
      public EvaluationContext createEvaluationContext(Authentication a,
                FilterInvocation f) {
          StandardEvaluationContext ctx =
                   (StandardEvaluationContext) super.createEvaluationContext(a, f);

           WebSecurityExpressionRoot myRoot =
                    new MyCustomWebSecurityExpressionRoot(a, f);

           ctx.setRootObject(myRoot);
           return ctx;
      }
 }