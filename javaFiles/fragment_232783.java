Box box = Box.createVerticalBox();
for (int i = 0; i < contents.size(); i++){
    String configuration = contents.get(i);
    JCheckBox currentCheckBox = new JCheckBox(configuration);
    if (whiteList.contains(configuration)){
        currentCheckBox.setSelected(true);
    }
    box.add(currentCheckBox);
}