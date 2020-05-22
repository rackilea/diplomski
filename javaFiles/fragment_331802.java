sr = new Search(((String) jComboBoxReceiver.getSelectedItem()));    
DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBoxReceiver.getModel();
model.remvoeAllElements();
usrList = sr.searchUser();
String[] userList = new String[usrList.size()] ;
for(int i=0;i<usrList.size();i++){
    String username = usrList.get(i).getUserName();
    System.out.println(username); // feel free to instead use one loger
    model.addElement(username);
}