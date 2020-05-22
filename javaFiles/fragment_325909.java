@Override
@Bean
public HandlerMapping resourceHandlerMapping() {
    AbstractHandlerMapping handlerMapping = (AbstractHandlerMapping) super.resourceHandlerMapping();
    handlerMapping.setOrder(-1);
    return handlerMapping;
}