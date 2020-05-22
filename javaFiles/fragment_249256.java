List<Messages> messages = response.body().getMessages();
for (int i = 0; i < messages.size(); i++) {
    Message message = messages.get(i);
    Attachments attachment = message.getAttachments();
    /* do something with the attachment */
}