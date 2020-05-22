Edytor edytor = new Edytor();//here (new place)
 private void read_butActionPerformed(java.awt.event.ActionEvent evt) {                                         
     JFileChooser fileChooser = new JFileChooser();

     fileChooser.setCurrentDirectory(new 
     File(System.getProperty("user.home")));
     int path = fileChooser.showOpenDialog(this);
     if (path == JFileChooser.APPROVE_OPTION) {
         File selectedFile = fileChooser.getSelectedFile();
         System.out.println("Selected file: " + 
         selectedFile.getAbsolutePath());
         //Edytor.sciezka = selectedFile.getAbsolutePath();
         //new Edytor().EdytorShow(selectedFile.getAbsolutePath());//disabled(Moved out of function ;)
         edytor.EdytorShow(selectedFile.getAbsolutePath());//newly added
     }

     System.out.print(Edytor.sciezka);
 }