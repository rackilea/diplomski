int pos = chatMessages.indexOf(chatMessage);
if (pos == -1) {
    chatMessages.add(chatMessage);
} else {
    chatMessages.set(pos, chatMessage);
}