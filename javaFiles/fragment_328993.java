private static Map<RequestAction,String[]> actionMap = new HashMap<RequestAction, String[]>();

    static{
    actionMap.put(RequestAction.COMMAND1,new String[]{WebServiceConstants.ONE,WebServiceConstants.TWO,WebServiceConstants.FOUR,WebServiceConstants.THREE});
    actionMap.put(RequestAction.THREE,new String[]{WebServiceConstants.FIVE,WebServiceConstants.ONE,WebServiceConstants.TWO});}


    public Map<String,Object> execute(ServiceParam param) {

    String[] requestChain = getRequestChain(param);

    Map<String,Object> responseMap = new HashMap<String, Object>();


    for(String reqId : requestChain) {

        prepareForProcessing(param, tempMap,responseMap);

        param.getRequest().setReqId(reqId);

        //processing the request
        tempMap = Service.INSTANCE.process(param);

        //prepare responseMap using tempMap         

        param.setResponse(response);

    }

    return responseMap;
}