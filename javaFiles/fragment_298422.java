Map<String,String> configMap = new HashMap<String,String>();
    configMap.put("mode", "sandbox");
    IPNMessage ipnlistener = new IPNMessage(request,configMap);

    boolean isIpnVerified = ipnlistener.validate();
    String transactionType = ipnlistener.getTransactionType();
    Map<String,String> map = ipnlistener.getIpnMap();