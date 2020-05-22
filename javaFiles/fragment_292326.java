boolean found = false;
for (int j=0;j<name.length;j++){
    if (search.equals(name[j])){
        JOptionPane.showMessageDialog(null,"Name : " +name[j]);
        found = true;
        break;
    }
}

if(!found) {
    JOptionPane.showMessageDialog(null, search + " was not found");
}