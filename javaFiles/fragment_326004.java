final ListMessagesResponse response = mService.users().messages().list(user).setQ("from:----").execute();
final List<Message> messages = new ArrayList<Message>();
while (response.getMessages() != null) {
    messages.addAll(response.getMessages());
    if (response.getNextPageToken() != null) {
        String pageToken = response.getNextPageToken();
        response = service.users().messages().list(user).setQ("from:----").setPageToken(pageToken).execute();
    } else {
        break;
    }
}

final List<Message> fullMessages = new ArrayList<>();
final JsonBatchCallback<Message> callback = new JsonBatchCallback<Message>() {
    public void onSuccess(Message message, HttpHeaders responseHeaders) {
        fullMessages.add(message);
    }

    public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) {
        // do what you want if error occurs
    }
};
BatchRequest batch = mService.batch();
for (Message message : messages) {
    mService.users().messages().get(user, message.getId()).setFormat("full").queue(batch, callback);
}

batch.execute();