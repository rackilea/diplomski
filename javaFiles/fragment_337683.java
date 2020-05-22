Map<String, String> nsMap = new HashMap<>();

nsMap.put("prefix1", "url1");
nsMap.put("prefix2", "url2");
nsMap.put("prefix3", "url3");
nsMap.put("prefix4", "url4");
nsMap.put("prefix5", "http://www.w3.org/2001/04/xmlenc#");

Client client = ClientProxy.getClient(port);   
client.getRequestContext().put("soap.env.ns.map", nsMap);