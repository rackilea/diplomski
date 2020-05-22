public class SelectElementWrapperHandler implements InvocationHandler {
    private final ElementLocator locator;

    public SelectElementWrapperHandler(ElementLocator locator) {
        this.locator = locator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        CustomSelect element;
        try {
            element = new CustomSelect(locator.findElement());
        } catch (Exception e) {
            if ("toString".equals(method.getName())) {
                return "Proxy select(element) for: " + locator.toString();
            }
            else throw e;
        }

        try {
            return method.invoke(element, args);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }

    }

}