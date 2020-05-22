private void openReplyListView(){
    JPanel panel = new ReplyListView();
    removeAll();
    setLayout(new BorderLayout());
    add(panel, BorderLayout.CENTER);
    validate();
    repaint();
}