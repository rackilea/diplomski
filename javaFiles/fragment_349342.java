public  void setList(Vector<String> files){
    // Good...
    listmodel_1.removeAllElements();
    // Not required, has nothing to do with the items in the list
    //list_1.removeAll();
    // Good
    for(int i=0;i<files.size();i++)
        listmodel_1. addElement(files.elementAt(i));
    // This here is your problem
    //list_1=new JList<String>(listmodel_1);
    // Because I have no idea what model list_1 is actually using...
    list_1.setModel(listmodel_1);
    //list_1.setSelectedIndex(0);
    //this.invalidate();
    //this.validate();
    //this.repaint();
}