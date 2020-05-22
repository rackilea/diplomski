User u=userList.get(table.getSelectedRow());  //get user for editing
int location=table.getSelectedRow();  //get location in list to maintain order
userList.remove(u);  //remove selected user to edit variables
//modify user u
userList.add(location,u);  //insert user at previous location in list
model.setRowCount(0);  //reset table model
for (int i = 0; i < userList.size(); i++) {  //refill table model 
    User u = userList.get(i);  /7get user
    Vector<Object> vhelp = new Vector<>(); //create vector to store the values of the variables from user
    vhelp.add(/*your data*/);  // 1 add per variable that should be displayed in table
    model.addRow(vhelp); //add the data to the table model (fills the table with data)
}