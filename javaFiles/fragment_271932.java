public void addMessage(Message message) throws Exception {        
    message.setMessageSentDate(new Date());
    messageService.save(message);
    List<User> registeredUsers = userService.getAll();
    for (User user : registeredUsers) {
        user.addMessage(message);
        userService.save(user);
    }
}