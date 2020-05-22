public String displayAllMessages(ModelMap model) {
    List<String> messages = fillMessages();
    model.put(messages, allMessages);
    return "messages";
}

private List<String> fillMessages() {
    List<String> allMessages = new ArrayList<>();
    allMessages.add("hello world");
    return allMessages;
}