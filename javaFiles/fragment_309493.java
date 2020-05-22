public void newChat(User user) {
  if (chatWindow == null) {
    // create chatWindow in a lazy fashion
    chatWindow = new JDialog(myMainFrame, "Chat", /* modality type */);
    // ...  set up the chat window dialog
  }

  chatWindow.setVisible(true);
  addTabWithUser(user);
}