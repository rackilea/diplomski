DefaultListModel listModel = new DefaultListModel();
JList list = new JList(listModel);

while(x<=m && JComboBox.getSelectedItem().equals("Linijinis")){

     addNewElement(String.valueOf(lin));
     x++;
}

public static void addNewElement(String elementToAdd)
{
    listModel.addElement(elementToAdd);
}