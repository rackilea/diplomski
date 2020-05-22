if(jTable1.getSelectedRow()!=-1) {
    int index = jTable1.getSelectedRow();
    Family s = list.get(index);
    id = s.getId();
    System.out.println("ID from search frame "+id);

    // FamilyInsert f = new FamilyInsert();
    // f.setFid(id);
    familyInsert.setFid(id); // **** add

    this.dispose();
    //JOptionPane.showMessageDialog(this, s.getId()+"\n"+s.getName());                    
}