DefaultListModel model = new DefaultListModel();
for(File f : yourFileList) {
    model.addElement(f);
}

yourList.setModel(model);