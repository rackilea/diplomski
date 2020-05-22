public void onSubmitChatClicked() {
    EventComment commentModel = new EventComment();
    String currentDate = EventDateTime.getCurrentDate();
    String currentTime = EventDateTime.getCurrentTime();
    String commentDesc = String.valueOf(txtEventChat.getText());
    commentModel.setCommentBy(userID);
    commentModel.setEventID(eventID);
    commentModel.setCommentDate(currentDate);
    commentModel.setCommentTime(currentTime);
    commentModel.setCommentDesc(commentDesc);

    // Add the new element to your DB
    new CreateCommentAsyncTask(context).execute(commentModel);
    // Add the new element to your current ArrayList
    _commentlist.add(commentModel)
    // Update theListView, by updating the adapter
    mAdapter.notifyDataSetChanged();

    txtEventChat.setText("");
}