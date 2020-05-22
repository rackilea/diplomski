public void onEvent(FlowableEvent event) {

    // retrieve map from threadlocal
    Map<String, Object> variablesMap = VariableContextHolder.getInstance().get();
    String procInstId = "abc1234";
    String type = "case1";
    // save variables to map
    variablesMap.put("procInstId", procInstId);
    variablesMap.put("type", type);
}