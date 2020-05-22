// Setup mocks
    @Override
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {

    builderContext.registerBean("consumerBean", mock(ConsumerBean.class));


    builderContext.registerBean("userService", mock(CustomerService.class));
    }