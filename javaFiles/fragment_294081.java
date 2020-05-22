@Override
public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
    RequestMappingHandlerAdapter adapter = super.requestMappingHandlerAdapter();
    ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) adapter.getWebBindingInitializer();
    initializer.setPropertyEditorRegistrar(domainClassPropertyEditorRegistrar());
    return adapter;
}

@Bean
public DomainClassPropertyEditorRegistrar domainClassPropertyEditorRegistrar() {
    return new DomainClassPropertyEditorRegistrar();
}