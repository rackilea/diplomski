public void updateChatsData(final ChatsModel chatsModel) {
    try(Realm realm = Realm.getDefaultInstance()) {
        realm.executeTransaction(r -> {
            r.insertOrUpdate(chatsModel);
        });
    }
}