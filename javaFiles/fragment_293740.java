private void doTheTask(){
String prijs  = JOptionPane.showInputDialog(this, "Vul een bedrag in");
  try{
  //your task here.
}
catch (Exception letter){
  //Call the method again.
  doTheTask();
}
}