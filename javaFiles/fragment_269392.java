private List<String> allMessages;

public String displayAllMessages(ModelMap model) {
    allMessages = new ArrayList<>();
    fillMessages();
    model.put(messages, allMessages);
    return "messages";
}

private void fillMessages() {
    allMessages.add("hello world");
}