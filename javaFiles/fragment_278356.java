Iterator<Message> it = messagesList.iterator();
while (it.hasNext()) {
    if (it.next().getId().length == 0) {
       it.remove();
    }
}