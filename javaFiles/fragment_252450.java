public void recieveUpdatedMessage(String channelName, Map<String, Object> input) {
    HashMap<String, String> insertMap = new HashMap<>();
    insertMap.put(chatText, input.get("text").toString());
    insertMap.put(firstName, input.get("firstname").toString());
    insertMap.put(groupChannel, "/service/chat" + input.get("groupaccountid").toString());

    myAdapter.add(insertMap);
}