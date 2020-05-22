public void createGroupChat(){
    String newGroupName = jAdminGroupChatName.getText().toString();
    GroupChats newGroupChat = new GroupChats(newGroupName);
    String newGroupKey = groupChatRoot.push().getKey();
    groupChatRoot.child(newGroupKey).setValue(newGroupChat);
    Toast.makeText(AdminActivity.this, "Group Chat Created - Key: " + newGroupKey, Toast.LENGTH_SHORT).show();
    jAdminGroupChatName.setText("");
}