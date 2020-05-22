private void fetchChatsFromNetwork(int count, AccessDataModel accessDataModel) {    
    String accessToken = accessDataModel.getAccessToken();
    Single<ChatsModel> chats = MyApplication.getRestApi().getChats(count, accessToken, Constants.api_version);
    chats.doOnNext((chats) -> {
        chatsRepository.insertOrUpdate(chats);
    }).subscribeOn(Schedulers.io())
    .subscribe();
}