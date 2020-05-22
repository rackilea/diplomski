// Note the AbstractAction constructor can take a String
exit.setAction(new AbstractAction("Exit"){ 
   public void actionPerformed(ActionEvent event){
     System.exit(0);
   }
}