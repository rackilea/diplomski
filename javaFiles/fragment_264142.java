private static class ControllerBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    protected String getBeanClassName(Element element) {
        return element.getAttribute("class");
    }

// code to parse XML omitted for brevity

}