Collections.sort(chatMessages, new Comparator<ChatMessage>() {
    @Override
    public int compare(ChatMessage o1, ChatMessage o2) {
        return o1.getTimestamp().compareTo(o2.getTimestamp());
    }
});