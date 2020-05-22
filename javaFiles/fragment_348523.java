TallestBuilding tallestBuilding = null;
for (int i=0; i<10; i++){
    if(name.equals(tallestbuilding[i].getName())){
       tallestBuilding = tallestbuilding[i];
       break;
    }
}
if(tallestBuilding == null) {
    JOptionPane.showInputDialog("Sorry - no "+ name + " was found.");
} else {
    JOptionPane.showMessageDialog(null, tallestBuilding);
}