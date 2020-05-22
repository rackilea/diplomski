Set<Entry> entries = jsonMap.entrySet();
for ( Entry entry : entries) {
    String sender= entry.getKey();
    String message= entry.getValue();
    TextMessage msg = new TextMessage(message, sender, "",0);
    System.out.println(msg.getMessage()+msg.getSender());
}