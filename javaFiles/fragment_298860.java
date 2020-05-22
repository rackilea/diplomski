public class CustomWebSecurityExpressionRoot extends WebSecurityExpressionRoot {

    public CustomWebSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
        super(a, fi);
    }

    public boolean yourCustomMethod() {
        boolean calculatedValue = ...;

        return calculatedValue;

    }
}