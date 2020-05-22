int[] selectedRow = jTable.getSelectedRows(); 
List<User> usersToBeRemoved = new ArrayList<>(selectedRow.length);
for(int row : selectedRow){
    // Is state part of the User object??
    Boolean state = (Boolean)jTable.getValueAt(row,10); 
    if(state){
        usersToBeRemoved.add(model.getUsers(row));
    }
}
DeleteUsersWorker worker = new DeleteUsersWorker(model, users);
worker.execute();