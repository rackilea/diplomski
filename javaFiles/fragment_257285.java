public Message[] getUnreadMessages() {
    Message[] messages = inbox.getMessages(1, messageCount);
    List<Message> readMessages = new ArrayList<Message>();
    for (Message message : messages) {
        boolean isMessageRead = false;
        for (Flags.Flag flag : message.getFlags().getSystemFlags()) {
            if (flag == Flags.Flag.SEEN) {
                readMessages.add(message);
                break;
            }
        }
    List<Message> unread = Arrays.asList(messages).removeAll(readMessagess); 
    return unread .toArray(new Message[unread.size()]);
}