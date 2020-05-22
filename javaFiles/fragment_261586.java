DefaultListModel model = new DefaultListModel();
for(int i=0;i<nameData.length;i++){
    if(nameData[i]==null) break;
    model.addElement(nameData[i]);   // build defaultlistmodel
}
final JList list = new JList();
list.setModel(model);