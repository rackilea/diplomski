public void actionPerformed(ActionEvent e) {
   try{
      ExportRunner.exportToFile(list);
   } catch(IOException ioex) {
      handleItOrShowMessageToUser(ioex);
    }
 }