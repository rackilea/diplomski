List<Map> clientList=new ArrayList<Map>();
Map<String,String> clientNameMap = new HashMap<String,String>();

clientNameMap.put("clientName","abcd");
clientList.add(clientNameMap);

clientNameMap = new HashMap<String,String>();  //Initialize it again.
clientNameMap.put("clientName","defg");
clientList.add(clientNameMap);