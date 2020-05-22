QBPrivateChatManagerListener privateChatManagerListener = new QBPrivateChatManagerListener() {
    @Override
    public void chatCreated(final QBPrivateChat privateChat, final boolean createdLocally) {
        if(!createdLocally){
            privateChat.addMessageListener(privateChatMessageListener);
        }
    }
};
QBChatService.getInstance().getPrivateChatManager().addPrivateChatManagerListener(privateChatManagerListener);