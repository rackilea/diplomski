ArrayList<User> uList=getUsers();
DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
for(int i=0;i<uList.size();i++){
    Object[] row=new Object[4];

    row[0]=uList.get(i).getId();
    row[1]=uList.get(i).getFname();
    row[2]=uList.get(i).getLname();
    row[3]=uList.get(i).Age();
      model.addRow(row);
}