class MyFlowHandlerAdapter extends DefaultFlowHandlerAdapter {
  public String createFlowDefinitionUrl(String flowId, AttributeMap input, HttpServletRequest request) {
    MuttableAttributeMap filteredInput = new MuttableAttributeMap(input);
    // remove the velocity parameters
    filteredInput.remove("velocity.param1");
    // build the url
    return super.createFlowDefinitionUrl(flowId,filteredInput,request);
  }

}