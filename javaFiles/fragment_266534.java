public void testFoo() {
    FlowExecution flowExecution = getFlowExecutionFactory().createFlowExecution(getFlowDefinition());
    updateFlowExecution(flowExecution);
    flowExecution.getConversationScope().put("fooBar", "goo");
    flowExecution.start(null, new MockExternalContext());        
    assertCurrentStateEquals("fooView");
}