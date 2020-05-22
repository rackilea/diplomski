for (Message savedMessage : messages) {
    if(user.getUserJoinedAt().before(savedMessage.getMessageSentDate())){
        user.addMessage(savedMessage);
    }
}
userService.save(user);