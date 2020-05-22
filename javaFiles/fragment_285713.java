while (again == JOptionPane.YES_OPTION){
    JOptionPane.showInputDialog(null, /*need help here*/);
    flag=true;
}
while (again == JOptionPane.NO_OPTION){
    JOptionPane.showMessageDialog(null, "Closing...");
    flag=false;
    System.exit(0);
}