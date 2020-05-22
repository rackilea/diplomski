private static class ControllerBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    protected Class<?> getBeanClass(Element element) {
        try {
            return Class.forName(element.getAttribute("class"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class " + element.getAttribute("class") + "not found.", e);
        }
    }

// code to parse XML omitted for brevity

}