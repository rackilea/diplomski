class PropertiesNode {
    Properties properties;
    Node node;
    // getter & setter
}

class Node {
    String id;
    String type;
    // getter & setter
}

class Properties {
    Map<String, Object> timeStamp;
    Map<String, String> macAddress;
    Map<String, Integer> tables;
    Map<String, Integer> capabilities;
    Map<String, Integer> tier;
    Map<String, String> supportedFlowActions;
    Map<String, Integer> buffers;
    Map<String, String> description;
    Map<String, Integer> forwarding;
    // getter & setter
}

Gson gson = new Gson();
Type type = new TypeToken<Map<String, ArrayList<PropertiesNode>>>() {}.getType();
Map<String, ArrayList<PropertiesNode>> nodeProperties = gson.fromJson(br, type);
System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(nodeProperties).toString());