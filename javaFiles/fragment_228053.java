try {
  JFileChooser fileChooser = new JFileChooser();
  int returnValue = fileChooser.showOpenDialog(null);
  if (returnValue == fileChooser.APPROVE_OPTION){
      File file = fileChooser.getSelectedFile();
      Scanner InFile = new Scanner(new FileReader(file));
  while(InFile.hasNext()) {
      String string1 = InFile.next();
      System.out.print(" " + string1);
  }
} catch(IOException e) {
    e.printStackTrace();  // or handle in some other way
}