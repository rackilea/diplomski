DefaultListModel listModel = new DefaultListModel();
while ((strLine = br.readLine()) != null)   
{
        listModel.addElement(strline); 
        System.out.println(strLine); 
}

jList1.setModel(listModel);