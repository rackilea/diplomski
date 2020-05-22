public class MyValidationTraversableResolver extends DefaultTraversableResolver {

    public MyValidationTraversableResolver() {
        //we simply override the constructor to disable jpa detection
    }

    @Override
    public boolean isReachable(Object traversableObject, Path.Node traversableProperty, Class<?> rootBeanType, Path pathToTraversableObject, ElementType elementType) {
        return true;
    }

    @Override
    public boolean isCascadable(Object traversableObject, Path.Node traversableProperty, Class<?> rootBeanType, Path pathToTraversableObject, ElementType elementType) {
        return true;
    }
}