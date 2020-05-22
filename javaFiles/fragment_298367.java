DefaultTableModel model = (DefaultTableModel) jTableUsers.getModel();
    User u = userList.get(jTableUsers.getSelectedRow());
    int location=jTableUsers.getSelectedRow();
    userList.remove(u);
    u.setName(jTextFieldName.getText());
    u.setAdress(jTextFieldAdress.getText());
    u.setNumCC(Integer.parseInt(jTextFieldNumCC.getText()));
    u.setTele(Integer.parseInt(jTextFieldTele.getText()));
    //u.isAdmin can't tell what this has to be
    userlist.add(location,u);

    model.setRowCount(0);  
    for (int i = 0; i < userList.size(); i++) {  
        User u = userList.get(i);  
        Vector<Object> vhelp = new Vector<>(); 
        vhelp.add(u.getName()); 
        vhelp.add(u.getAddress());
        vhelp.add(u.getTele());
        vhelp.add(u.getNumCC());
        vhelp.add(u.isAdmin);
        model.addRow(vhelp);
    }
    JOptionPane.showMessageDialog(null, "Data updated.");