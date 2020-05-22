public class MyCustomWebSecurityExpressionHandler
              extends DefaultWebSecurityExpressionHandler {

      @Override        
      public SecurityExpressionOperations createSecurityExpressionRoot(
                Authentication a,
                FilterInvocation f) {
           WebSecurityExpressionRoot myRoot =
                    new MyCustomWebSecurityExpressionRoot(a, f);

           myRoot.setPermissionEvaluator(getPermissionEvaluator());
           myRoot.setTrustResolver(this.trustResolver);
           myRoot.setRoleHierarchy(getRoleHierarchy());
           return myRoot;
      }
 }