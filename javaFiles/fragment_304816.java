@Bean 
@Autowired
public FlowHandlerAdapter flowHandlerAdapter(FlowExecutor flowExecutor) {
    FlowHandlerAdapter flowHandlerAdapter = new FlowHandlerAdapter();
    flowHandlerAdapter.setFlowExecutor(flowExecutor);

    return flowHandlerAdapter;
}

@Bean 
@Autowired
public FlowHandlerMapping flowHandlerMapping(FlowDefinitionRegistry flowDefinitionRegistry) {
    FlowHandlerMapping flowHandlerMapping = new FlowHandlerMapping();
    flowHandlerMapping.setFlowRegistry(flowDefinitionRegistry);
    flowHandlerMapping.setOrder(0);

    return flowHandlerMapping;
}