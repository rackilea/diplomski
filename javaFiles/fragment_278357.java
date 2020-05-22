int index;
for (index = messagesList.length - 1; index >= 0; --index) {
    if (messagesList.get(index).getId().length == 0) {
       messagesList.remove(index);
    }
}