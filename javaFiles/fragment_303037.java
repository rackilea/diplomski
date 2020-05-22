public ChatWindow(int id) {
    initComponents(); //otherPerson = "";
    userID = id;
    otherPerson = userID.toString(); //otherPerson = id;
    this.setVisible(true);
}