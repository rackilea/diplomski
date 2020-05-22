public class MyCustomWebSecurityExpressionRoot
         extends WebSecurityExpressionRoot {
     public MyCustomWebSecurityExpressionRoot(Authentication a,
                 FilterInvocation f) {
          super(a, f);
     }

     /** That method is the one that does the expression evaluation! */
     public boolean myCustomAuthenticatedExpression() {
        return super.request.getSession().getValue("myFlag") != null;
     }
}