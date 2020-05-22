for ( Map.Entry<String, String> entry : jsonMap.entrySet()) {
    String sender= entry.getKey();
    String message= entry.getValue();
    TextMessage msg = new TextMessage(message, sender, "",0);
    System.out.println(msg.getMessage()+msg.getSender());
}