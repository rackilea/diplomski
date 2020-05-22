public class MyControllerClassNameHandlerMapping extends ControllerClassNameHandlerMapping {

    @Override
    protected String[] generatePathMappings(Class<?> beanClass) {
        if (beanClass.isAnnotationPresent(RequestMapping.class)) {
            RequestMapping mapping = beanClass.getAnnotation(RequestMapping.class);
            return mapping.value();
        }
        return super.generatePathMappings(beanClass);
    }
}