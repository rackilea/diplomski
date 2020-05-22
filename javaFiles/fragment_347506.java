if (message.startsWith("!note ")) {
    addNote(sender.toLowerCase(), message.substring(6));
    sendMessage(channel, "Note recorded.");
}
if (message.startsWith("!remind ")) {
    String nick = message.substring(8);
    List<String> notes = userNotesStore.get(nick);
    if(notes != null) {
        // send all notes to the user.
        for(String note : notes) {
            sendMessage(channel, note);
        }
    } else {
        // send no notes message?
        sendMessage(channel, "*You have no notes recorded.");
    }
}