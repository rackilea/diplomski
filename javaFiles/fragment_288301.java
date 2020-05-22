public PrivateMessage sentMessage(String newMessage, User receiverUser) {
    PrivateMessage privateMessage = new PrivateMessage(this.userName, newMessage);
    receiverUser.privateMessageList.add(privateMessage); // list is already created
    System.out.println("Message sent successfully!");
    return privateMessage;
}