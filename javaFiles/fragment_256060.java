DefaultListModel<String> jList1Model = new DefaultListModel<>();

// probably a loop where you call printChannelData()
List<ChannelData> channels = ...;
for (ChannelData cd : channels) {
    printChannelData(cd, "whatever");
}


private void printChannelData(Channel channel, String nodeName) {   
    String channelId = channel.getId() + " - " + nodeName + " - " + channel.getName();
    for (int i=0; i < channelId.length; i++) {
        //Adds element to the Single Channel Loading ComboBox
        channelIdComboBox.addItem(channelId[i]);
        //Adds elements to the Multiple Channel Loading ComboBox
        jList1Model.addElement(channelId[i]); 
    }
    jList1.setModel(jList1Model);   
}