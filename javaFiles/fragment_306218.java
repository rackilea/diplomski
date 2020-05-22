String[] data = {"one", "two", "three", "four"};
JList dataList = new JList(data);

for(int i = 0; i < dataList.getModel().getSize(); i++) {
    String item = (String)dataList.getModel().getElementAt(i);
    saveItemToDatabase(item);
}