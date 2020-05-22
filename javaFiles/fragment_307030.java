MuleContext context = new DefaultMuleContextFactory().createMuleContext();
    MuleRegistry registry = context.getRegistry();

    EndpointBuilder testEndpointBuilder = new EndpointURIEndpointBuilder("vm://testFlow.in",
        context);
    testEndpointBuilder.setExchangePattern(MessageExchangePattern.REQUEST_RESPONSE);
    registry.registerEndpointBuilder("testFlow.in", testEndpointBuilder);

    InboundEndpoint vmInboundEndpoint = testEndpointBuilder.buildInboundEndpoint();
    registry.registerEndpoint(vmInboundEndpoint);

    StringAppendTransformer stringAppendTransformer = new StringAppendTransformer(" world");
    stringAppendTransformer.setMuleContext(context);

    Flow testFlow = new Flow("testFlow", context);
    testFlow.setMessageSource(vmInboundEndpoint);
    testFlow.setMessageProcessors(Arrays.asList((MessageProcessor) stringAppendTransformer));
    registry.registerFlowConstruct(testFlow);

    context.start();

    MuleClient muleClient = new MuleClient(context);
    MuleMessage response = muleClient.send("vm://testFlow.in", "hello", null);
    Validate.isTrue(response.getPayloadAsString().equals("hello world"));

    muleClient.dispose();
    context.stop();